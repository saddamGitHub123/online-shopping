$(function(){

	//solving the active menu problem
	switch(menu){
	
	case 'About Us' :
		$('#about').addClass("active");
		break;
		
	case 'Contact Us' :
		$('#contact').addClass("active");
		break;
		
	case 'All Products' :
		$('#listProducts').addClass("active");
		break;
		
	default :
		if(menu == "Home") break;
		$('#listProducts').addClass("active");
	    $('#a_'+menu).addClass("active");
		break;
	}
	
	
	//code for jquery dataTable
	//create a dataTable
	
/*	var products = [
	                ['1','ABC'],
	                ['2','DEF'],
	                ['3','GHI'],
	                ['4','KLM'],
	                ['5','NOP'],
	                ['6','QRS'],
	                ['7','TUV'],
	                ['8','WXY']
	                
	                ];*/
	
	
	
	
	var $table = $('#productListTable');
	
	//execute the below code only where we have this table
	
	if($table.length){
	console.log("Inside the table")
	
	var jsonUrl = '';
	
	if(window.categoryId==''){
		
		jsonUrl = window.contextRoot + '/json/data/all/products';
		
	}else{
		
		jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
		
	}
	
	
	$table.DataTable({
		
		lengthMenu: [[3,5,10,-1],['3 Records', '5 Records', '10 Records', 'ALL']],
		pageLength: 5,
		//data: products
		ajax:{
			
			url:jsonUrl,
			dataSrc:''
		},
		columns: [
		         {
		        	 data: 'name'
		        	 
		         },
		         
		         {
		        	 data: 'brand'
		        	 
		         },
		         
		         {
		        	 data: 'unitPrice',
		        	 mRender: function(data, type, row){
		        		 return '&#8377; '+ data
		        		 
		        	 }
		         },
		         {
		        	 data: 'quantity'
		         },
		         {
		        	 data: 'id',
		        	 mRender: function(data, type, row){
		        		 
		        		 var str = '';
		        		 str +='<a href="'+window.contextRoot+'/show'+data+'/product" class = "btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160';
		        		 str +='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class = "btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
		        		 return str;
		        	 }
		        	 
		         }
		         
		         
		         ]
		
	})
	
	
	}
	
})

