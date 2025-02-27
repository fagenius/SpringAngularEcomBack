/**
 * 
 */

$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event){
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleModel, status){
			$('#idEdit').val(vehicleModel.id);
			$('#descriptionEdit').val(vehicleModel.description);
			$('#detailsEdit').val(vehicleModel.details);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleModel, status){
			$('#idDetails').val(vehicleModel.id);
			$('#descriptionDetails').val(vehicleModel.description);
			$('#detailsDetails').val(vehicleModel.details);
			$('#createdByDetails').val(vehicleModel.createdBy);
			$('#createdDateDetails').val(vehicleModel.createdDate);
			$('#lastModifiedByDetails').val(vehicleModel.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicleModel.lastModifiedDate);
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