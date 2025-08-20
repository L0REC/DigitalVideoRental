document.addEventListener("DOMContentLoaded", function() {
	document.querySelectorAll(".delete").forEach(btn => {
		btn.addEventListener("click", function(e) {
			e.stopPropagation();

			const videoId = this.dataset.videoId;
			const title = this.dataset.title;

			if (confirm(`「${title}」を削除します。よろしいですか？`)) {
				e.preventDefault();
				window.location.href = `/catalog/remove/${videoId}`;
			}
		});
	});
});