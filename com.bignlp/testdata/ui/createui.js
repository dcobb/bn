(function() {
	var HTMLParser = new (function(){
		var domElem = $("<div/>");
		this.encode = function(data) {
			return domElem.text(data).html();
		};
		this.decode = function(data) {
			return domElem.html(data).text();
		} ;
	})();

	var debugApi = new (function(){
		var debug = false;
		this.log = function(text) {
			if(debug) {
				console.log(text);
			}
		};
	})();

	var isValid = new (function(){
		this.annotation = function(ann) {
			if(!("startPosition" in ann && "endPosition" in ann /*"conceptName" in ann && "tags" in ann && ann.tags.length > 0 */ && ann.startPosition < ann.endPosition)) {
				debugApi.log(ann);
				return false;
			}
			return true;
		};
	})();

	var getSymanticName = function(semType) {
		if (SemanticsMap && semType in SemanticsMap) {
			return SemanticsMap[semType];
		}
		return semType;
	}

	var MedicalData = function(data, semanticPriority) {
		var content = data.input.content, annotations = data.annotations, semanticMap = {}, semArr = [];

		(function() {
			var annotation, tag, conceptName;
			for (var i = 0, l = annotations.length; i < l; i++) {
				annotation = annotations[i];
				if (!isValid.annotation(annotation)) {
					continue;
				}

				/* This try catch is to handle tags which is not there in the first level of annotation */
				try {
					tag = annotation.tags[0];
				} catch(e) {
					if (!annotation.details.phraseParts) {
						continue;
					}
					tag = annotation.details.phraseParts[0].tags[0]
					annotation["tags"] = [tag];
				}
				
				conceptName = undefined;
				if("conceptName" in annotation) {
					conceptName = annotation.conceptName;
				} else {
					if (annotation.details.phraseParts && annotation.details.phraseParts[0] && "conceptName" in annotation.details.phraseParts[0]) {
						conceptName = annotation.details.phraseParts[0].conceptName;
						annotation["conceptName"] = conceptName;
					}
				}
				if(conceptName === undefined) {
					conceptName = annotation.phrase;
				}
				
				annotation["matchedWord"] = content.substring(annotation.startPosition, annotation.endPosition);

				if (semanticPriority && !( tag in semanticPriority)) {
					tag = "Misc";
				}

				if (!semanticMap[tag]) {
					var conceptMap = {};
					conceptMap[conceptName] = [annotation];
					semanticMap[tag] = conceptMap;
				} else {
					conceptMap = semanticMap[tag];
					if(conceptName in conceptMap) {
						conceptMap[conceptName].push(annotation);
					} else {
						conceptMap[conceptName] = [annotation];
					}
				}
			}
		})();

		this.getContent = function() {
			return content;
		};

		var getSemanticArray = function() {
			return semArr;
		};

		this.getSemanticArray = function() {
			for (var tag in semanticMap) {
				semArr.push(tag);
			}
			this.getSemanticArray = getSemanticArray;
			var comparator = function(a, b) {
				if (a in semanticPriority && b in semanticPriority) {
					return semanticPriority[a] - semanticPriority[b];
				} else if (a in semanticPriority) {
					return -1;
				} else if (b in semanticPriority) {
					return 1;
				} else {
					return semanticMap[b].length - semanticMap[a].length;
				}
			};
			semArr.sort(comparator);
			return semArr;
		};

		this.getConceptObjOfSemantics = function(semType) {
			return semanticMap[semType];
		};
	};

	var constructHTML = function(dataInstance) {
		var leftLinkTemplate = "<li class=\"active\" id=\"{$0}\"><a href=\"#\"><i class=\"icon-dashboard\"></i>{$1}</a></li>";
		var middleLinkTemplate = "<li iden=\"{$0}\"><a>{$1}</a></li>";
		var rightLinkTemplate = "<a rel=\"popover\" data-title=\"{$0}\" data-content=\"{$1}\">{$2}</a>";

		var replaceTokens = function(template, arr) {
			var replace = function(a, b) {
				return arr[parseInt(b.substring(1))];
			};
			return template.replace(/\{(.+?)\}/g, replace);
		};

		this.getLeftNavMarkup = function() {
			var semArr = dataInstance.getSemanticArray(),
			str = '<nav id="primary" class="main-nav"><ul>';
			for (var i = 0; i < semArr.length; i++) {
				str += replaceTokens(leftLinkTemplate, [semArr[i], HTMLParser.encode(getSymanticName(semArr[i]))]);
			}
			str += "</ul></nav>";
			return str;
		};

		this.getMiddleNavMarkup = function(semantic) {
			var conceptObj = dataInstance.getConceptObjOfSemantics(semantic);
			var str = '<ul>';
			for (var conceptName in conceptObj) {
				str += replaceTokens(middleLinkTemplate, [HTMLParser.encode(semantic + "_" + conceptName), HTMLParser.encode(conceptName + " ("+ conceptObj[conceptName].length +")")]);
			}
			str += "</ul>";
			return str;
		};

		this.getRightTextMarkup = function(annotation) {
			return replaceTokens(rightLinkTemplate, [HTMLParser.encode(annotation["matchedWord"]), HTMLParser.encode(getSymanticName(annotation.tags[0])), HTMLParser.encode(annotation["matchedWord"])]);
		};
		
		var getHoverText = function(annotation) {
			var hoverData = annotation["details"]["phraseParts"];
			var returnStr = "";
			for(var i=0;i<hoverData.length;i++) {
				returnStr += hoverData[i]["phrase"];
				returnStr += "(";
				var tags = hoverData[i]["tags"];
				for(var j=0;j<tags.length;j++) {
					returnStr += (j!==0) ? "," + getSymanticName(tags[j]) : getSymanticName(tags[j]);
				}
				returnStr += ")";
				returnStr += "<br/>";
			}
			return returnStr;
		};

		this.getRightContent = function(iden) {			
			var conObj = dataInstance.getConceptObjOfSemantics(iden.substring(0, iden.lastIndexOf("_"))),
			annotations = conObj[iden.substring(iden.lastIndexOf("_") + 1)],
			content = dataInstance.getContent(),
			prevEnd = 0,
			returnStr = "";
			for (var i = 0, l = annotations.length; i < l; i++) {
				var annotation = annotations[i];
				returnStr += content.substring(prevEnd, annotation.startPosition);
				returnStr += replaceTokens(rightLinkTemplate, [HTMLParser.encode(annotation["matchedWord"]), HTMLParser.encode(getSymanticName(annotation.tags[0])), HTMLParser.encode(annotation["matchedWord"])]);
				prevEnd = annotation.endPosition;
			}
			returnStr += content.substring(prevEnd);			
			return returnStr;
		};
	};

	var updateUI = function(url) {
		var callback = function(data) {
			var medObj = new MedicalData(data, {
				"sosy" : 0,
				"dsyn" : 1,
				"diap" : 2,
				"phsu" : 3,
				"bpoc" : 4
			});
			var htmlObj = new constructHTML(medObj);
			$('#menu-left').html(htmlObj.getLeftNavMarkup());
			$('#rightdiv').html(medObj.getContent().replace(/\n/g, "<br/>"))
			$('[rel="popover"]').popover({
				placement : 'bottom',
				trigger : 'hover'
			});

			$('#menu-left').delegate('li', 'click', function() {
				$('#menu-left li').removeClass('selected');
				var curObj = $(this);
				curObj.addClass('selected');
				var id = curObj.attr("id");
				$('#centerdiv .content').html(htmlObj.getMiddleNavMarkup(id));
				$('#rightdiv').html(medObj.getContent().replace(/\n/g, "<br/>"));
				$('#centerdiv').removeClass('hide');
			});

			$('#centerdiv').delegate('.content li', 'click', function() {
				$('#centerdiv .content li').removeClass('selected');
				var curObj = $(this);
				curObj.addClass('selected');
				var iden = curObj.attr("iden");
				$('#rightdiv').html(htmlObj.getRightContent(iden).replace(/\n/g, "<br/>"));
				$('[rel="popover"]').popover({
					placement : 'bottom',
					trigger : 'hover'
				});
			});

		};
		if ( typeof url === "string") {
			$.getJSON(url, callback);
		} else {
			callback(url);
		}
	};

	window.updateUI = updateUI;
	updateUI('sample1.doc1352129020540.trimmed.txt.1352129151087.dab.js');
})();
