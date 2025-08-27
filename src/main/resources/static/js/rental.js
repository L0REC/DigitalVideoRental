document.addEventListener("DOMContentLoaded", function() {
	const rentButton = document.getElementById('rentButton');

	if (rentButton) {
		rentButton.addEventListener('click', function() {
			const videoId = this.dataset.videoId;
			const formData = new FormData();
			formData.append('videoId', videoId);
			fetch('/rental', {
				method: 'POST',
				body: formData
			})
				.then(response => {
					if (response.ok || response.redirected) {
						location.reload();
					} else {
						alert('レンタルエラー');
					}
				});
		});
	}
});