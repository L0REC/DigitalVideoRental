document.addEventListener("DOMContentLoaded", function() {
	const rentButton = document.getElementById('rentButton');

	if (rentButton) {
		rentButton.addEventListener('click', function() {

			if (this.disabled) return;
			this.disabled = true;

			const originalText = this.textContent;
			this.textContent = 'レンタル中...';

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

						this.disabled = false;
						this.textContent = originalText;
					}
				})
				.catch(error => {
					console.error('ネットワークエラー:', error);
					this.disabled = false;
					this.textContent = originalText;
					alert('ネットワークエラー');
				});
		});
	}
});