(function() {
	var HTMLParser = new (function(){
	var domElem = $("<div/>");
	this.encode = function(data) {
		return $("<div/>").text(data).html();
	};
	this.decode = function(data) {
		return $("<div/>").html(data).text();
	} ;
	})();
	var Tagger = function(data) {
		var content = data.input.content;
		var annotations = data.annotations;
		var taggedContent;
		var linkTemplate = ["<a href=\"#\" rel=\"popover\" data-title=\"", "\" data-content=\"", "\">", "</a>"];
		var navObj = {};
		var navContent = "";

		var getPopupContent = function(annotation) {
			return annotation.tags[0];
		};

		(function() {
			var contentWithTags = '';
			var prevEnd = 0;
			var annotation;
			/* Process : START */
			for (var i = 0, l = annotations.length; i < l; i++) {
				annotation = annotations[i];
				if (navObj[annotation.tags[0]]) {
					navObj[annotation.tags[0]].push(annotation.phrase);
				} else {
					navObj[annotation.tags[0]] = [annotation.phrase];
				}
				contentWithTags += content.substring(prevEnd, annotation.startPosition);
				contentWithTags += linkTemplate[0];
				contentWithTags += HTMLParser.encode(annotation.phrase);
				contentWithTags += linkTemplate[1];
				contentWithTags += HTMLParser.encode(getPopupContent(annotation));
				contentWithTags += linkTemplate[2];
				contentWithTags += annotation.phrase;
				contentWithTags += linkTemplate[3];
				prevEnd = annotation.endPosition;
			}
			contentWithTags += content.substring(prevEnd);
			/* Process : END */
			taggedContent = contentWithTags;
		})();

		this.getContent = function() {
			return content;
		};

		this.getTaggedContent = function() {
			return taggedContent;
		};

		this.getNavigationContent = function() {
			try {
				return JSON.stringify(navObj);
			} catch(e) {
				return "";
			}
		};
	};

	var updateUI = function(url, taggedContElem, navElem, contentElem) {
		var callback = function(data) {
			var taggerObj = new Tagger(data);
			if (taggedContElem) {
				taggedContElem.innerHTML = taggerObj.getTaggedContent().replace(/\\n/g, "<br/>")
			}
			if (navElem) {
				navElem.innerHTML = taggerObj.getNavigationContent().replace(/\\n/g, "<br/>")
			}
			if (contentElem) {
				contentElem.innerHTML = taggerObj.getContent().replace(/\\n/g, "<br/>")
			}
			$('[rel="popover"]').popover({
				placement : 'bottom',
				trigger : 'hover'
			});
		};
		$.getJSON(url,callback);
	};
	updateUI("/BootStrap/data.json", document.getElementById("leftpanel"), document.getElementById("rightpanel"));
})();
