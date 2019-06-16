/**
 * @author 이수아
 */

function reportCheck() {

	if (document.frm.bookTitle.value == "") {
		alert("책 제목을 입력해 주세요.");
		return false;
	}
	if (document.frm.writer.value == "") {
		alert("저자를 입력해 주세요.");
		return false;

	}
	if (document.frm.publisher.value == "") {
		alert("출판사를 입력해 주세요.");
		return false;

	}
	if (document.frm.reportTitle.value == "") {
		alert("제목을 입력해 주세요.");
		return false;

	}
	if (document.frm.reportContent.value == "") {
		alert("내용을 입력해 주세요.");
		return false;
	}
	
	return true;
}
