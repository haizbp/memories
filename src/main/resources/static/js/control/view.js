var viewModel = new Vue({
	el : '#mainComponent',
	data : {
		input : '# hello',
		recommended : {
			content: [],
			limitRecords: 12,
			loadData : function() {
				var self = this;
				$.ajax({
					type : 'GET',
					url : '/video/random/'+self.limitRecords,
					success : function(msg) {

						if (msg.code == 200) {
							self.content = msg.data;
						}

					}
				});
			}
		}
	},
	methods : {
	
	},
	mounted () {
		var self = this;
		this.recommended.loadData();
	}
});