/**
 *
 */

$('document').ready(function() {

	$('.table .btn-primary').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(location, status){
			$('#idedite').val(location.id);
			$('#adressedit').val(location.adress);
			$('#cityedit').val(location.city);
			$('#ddCountryDetailsedit').val(location.countryid);
			$('#descriptionedit').val(location.description);
			$('#deltailsedit').val(location.details);
			$('#ddStateDetailsedit').val(location.stateid);
		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(location, status){
			$('#idDetails').val(location.id);
			$('#adressDetails').val(location.adress);
			$('#cityDetails').val(location.city);
			$('#ddlCountryDetails').val(location.countryid);
			$('#descriptionDetails').val(location.description);
			$('#detailsDetails').val(location.details);
			$('#ddStateDetaildetails').val(location.stateid);
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