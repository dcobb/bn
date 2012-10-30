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
	var Tagger = function(data) {
		var content = data.input.content;
		var annotations = data.annotations;
		var taggedContent;
		var linkTemplate = ["<a rel=\"popover\" data-title=\"", "\" data-content=\"", "\" name=\"", "\">", "</a>"];
		var navObj = {};
		var navContent = "";

		this.getNavigationContent = function() {
			var navBoxTemplate = ["<div class=\"box\"><div class=\"header\">","</div><div class=\"links\">", "</div></div>"];
			var navLinkTemplate = ["<div class=\"rightlink\"><a href=\"#", "\">", "</a></div>"];
			for(var key in navObj) {
				navContent += navBoxTemplate[0];
				navContent += key;
				navContent += navBoxTemplate[1];
				var arr = navObj[key];
				for(var i=0,l=arr.length;i<l;i++){
					navContent += navLinkTemplate[0];
					navContent += arr[i]["id"];
					navContent += navLinkTemplate[1];
					navContent += arr[i]["word"];
					navContent += navLinkTemplate[2];	
				} 
				navContent += navBoxTemplate[2];				 
			}
			this.getNavigationContent = function() {
				return navContent;
			};
			return navContent;
		};

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
				if(annotation.endPosition>content.length) {
					console.log("annotation.endPosition"+ annotation.endPosition);
					console.log("annotation.startPosition"+ annotation.startPosition);
					console.log("content length"+ content.length);
				}
				if (navObj[annotation.tags[0]]) {
					navObj[annotation.tags[0]].push({word:content.substring(annotation.startPosition, annotation.endPosition), id:i});
				} else {
					navObj[annotation.tags[0]] = [{word:content.substring(annotation.startPosition, annotation.endPosition), id:i}];
				}
				
				contentWithTags += content.substring(prevEnd, annotation.startPosition);
				contentWithTags += linkTemplate[0];
				contentWithTags += HTMLParser.encode(content.substring(annotation.startPosition, annotation.endPosition));
				contentWithTags += linkTemplate[1];
				contentWithTags += HTMLParser.encode(getPopupContent(annotation));
				contentWithTags += linkTemplate[2];
				contentWithTags += i;
				contentWithTags += linkTemplate[3];
				contentWithTags += HTMLParser.encode(content.substring(annotation.startPosition, annotation.endPosition));
				contentWithTags += linkTemplate[4];
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

	};

	var updateUI = function(url, taggedContElem, navElem, contentElem) {
		var callback = function(data) {
			var taggerObj = new Tagger(data);
			if (taggedContElem) {
				taggedContElem.innerHTML = taggerObj.getTaggedContent().replace(/\n/g, "<br/>")
			}
			if (navElem) {
				navElem.innerHTML = taggerObj.getNavigationContent().replace(/\n/g, "<br/>")
			}
			if (contentElem) {
				contentElem.innerHTML = taggerObj.getContent().replace(/\n/g, "<br/>")
			}
			$('[rel="popover"]').popover({
				placement : 'bottom',
				trigger : 'hover'
			});
		};
		if(typeof url === "string"){
			$.getJSON(url,callback);
		} else {
			callback(url);
		}
	};
	
	window.updateUI = updateUI;
	//updateUI("/BootStrap/data.json", document.getElementById("leftpanel"), document.getElementById("rightpanel"));
})();
