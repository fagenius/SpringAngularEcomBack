/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(state, status){
			$('#idedite').val(state.id);
			$('#capitaledit').val(state.capital);
			$('#codeedit').val(state.code);
			$('#ddCountryDetailsedit').val(state.countryid);
			$('#deltailsedit').val(state.details);
			$('#namedite').val(state.name);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(state, status){
			$('#idDetails').val(state.id);
			$('#capitalDetails').val(state.capital);
			$('#codeDetails').val(state.code);
			$('#ddlCountryDetails').val(state.countryid);
			$('#deltailsDetails').val(state.details);
			$('#nameDetails').val(state.name);
			$('#lastModifiedByDetails').val(state.lastModifiedBy);
			$('#lastModifiedDateDetails').val(state.lastModifiedDate);
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