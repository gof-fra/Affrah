$(function() {
	
	switch(menu) {
	
		case 'About Us':
			$('#about').addClass('active');
			break;
		case 'Contact U':
			$('#contact').addClass('active');
			break;
		case 'Pages':
			$('#pages').addClass('active');
			break;
		case 'Electronics':
			$('#elect').addClass('active');
			break;
			
		default:
			$('#home').addClass('active');
			break;
				
	}
	
	var $table = $('#productListTable');
	
	if($table.length) {
		
		var jsonUrl = '';
		if(window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}else{
			jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products';
		}
		
		$table.DataTable( {
			
			lengthMenu: [[1, 3, 5, 10, -1], ['1 Record', '3 Records', '5 Records', '10 Records', 'ALL' ]],
			pageLength: 5,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [	
				{
					data: 'code',
					mRender: function(data, type, row) {
						
						return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
						
					}
				},
				{
					data: 'name'
				},
				{
					data: 'brand'
				},
				{
					data: 'unitPrice',
					mRender: function(data, type, row) {
						
						return '&#8377; ' +data
						
					}
				},
				{
					data: 'quantity',
					mRender: function(data, type, row) {
						
						if(data < 1) {
							
							return '<span style="color:red">Out to stock!</span>';
							
						}
						
						return data;
						
					}
				},
				{
					data: 'id',
					bSortable: false,
					mRender: function(data, type, row) {
						
						var str = '';
						str += '<a href="'+window.contextRoot+ '/show/'+data+'/product" class="btn btn-primary"> <span class="glyphicon glyphicon-eye-open"> </span> </a> &#160;';
						
						if(row.quantity < 1) {
							
							str += '<a href="javascript:void(0)" class="btn btn-success disabled" > <span class="glyphicon glyphicon-shopping-cart"> </span> </a>';
							
							
						}else {
							
							str += '<a href="'+window.contextRoot+ '/cart/add/'+data+'/product" class="btn btn-success" > <span class="glyphicon glyphicon-shopping-cart"> </span> </a>';
							
						}
						
						
						return str;
					}
				}
		
		
			 ]
	
	
	
});

}

	
	// dismissing the alert after 3s
	var $alert = $('.alert');
	
	if($alert.length) {
		
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
		
	}
	
	
});