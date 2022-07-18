/**
 * 
 */

$('document').ready(function() {
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(country, status){
			$('#idedite').val(country.id);
			$('#codeedit').val(country.code);
			$('#capitaledit').val(country.capital);
			$('#descriptionedit').val(country.capital);
			$('#nationalityedit').val(country.nationality);
			$('#continentedit').val(country.continent);
		});
		$('#editModal').modal();
	});

	$('table #deleteButton').on('click', function (event){
		event.preventDefault();
		var href= $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);
		$('#deleteModal').modal();
	});

});