/**
 * 
 */

$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event){
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(contact, status){
			$('#txtEmailEdit').val(contact.emailadress);
			$('#txtFirstnameEdit').val(contact.firstname);
			$('#txtIdEdit').val(contact.id);
			$('#txtLastnameEdit').val(contact.lastname);	
			$('#txtMobileEdit').val(contact.mobile);
			$('#txtPhoneEdit').val(contact.phone);			
			$('#txtRemarksEdit').val(contact.remarks);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(contact, status){
			$('#IdDetails').val(contact.id);
			$('#emailDetails').val(contact.emailadress);
			$('#firstnameDetails').val(contact.firstname);
			$('#lastnameDetails').val(contact.lastname);
			$('#mobileDetails').val(contact.mobile);
			$('#phoneDetails').val(contact.phone);
			$('#remarksDetails').val(contact.remarks);
			$('#lastModifiedByDetails').val(contact.lastModifiedBy);
			$('#lastModifiedDateDetails').val(contact.lastModifiedDate);
			//$('#lastModifiedDateDetails').val(contact.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
});