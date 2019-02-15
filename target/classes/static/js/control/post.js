var viewModel = new Vue({
	el : '#mainComponent',
	data : {
		input : '# hello',
		form : {
			title: "",
			url: "",
			description: ""
		}
	},
	methods : {
		action: function(){
			var self = this;
			var data = {
					"title": self.form.title,
					"description": self.form.description,
					"url": self.form.url
			};
			
			$.ajax({
				type : 'POST',
				url : '/video',
				data: JSON.stringify(data),
				contentType: "application/json",
				success : function(msg) {

					if (msg.code == 200) {
						self.form.title = "";
						self.form.description = "";
						self.form.url = "";
					}

				}
			});
		}
	},
	mounted () {
		
	}
});