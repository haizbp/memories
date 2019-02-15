var viewModel = new Vue({
	el : '#mainComponent',
	data : {
		input : '# hello',
		recommended : {
			content: [],
			page: 1,
			recordPerPage: 0,
			totalPages: 0,
			totalRecords: 0,
			showLoadMore: true,
			loadData : function(keep) {
				var self = this;
				$.ajax({
					type : 'GET',
					url : '/video/all/'+self.page,
					success : function(msg) {

						if (msg.code == 200) {
							
							if(keep){
								$.each(msg.data.content, function( index, value ) {
									self.content.push(value);
								});
							}else{
								self.content = msg.data.content;
							}

							self.page = msg.data.page;
							self.recordPerPage = msg.data.recordPerPage;
							self.totalPages = msg.data.totalPages;
							self.totalRecords = msg.data.totalRecords;
							
							if(self.page == self.totalPages){
								self.showLoadMore = false;
							}
						}

					}
				});
			}
		}
	},
	methods : {
		loadMore : function() {
			var self = this;
			self.recommended.page = self.recommended.page + 1;
			self.recommended.loadData(true);
		}
	},
	mounted () {
		var self = this;
		this.recommended.loadData();
	}
});