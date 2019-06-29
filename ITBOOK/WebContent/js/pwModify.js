/**
 * @author 이수아
 */

function pwModify() {

	if (document.frm.memPwCheck.value == "") {
		alert("변경할 비밀번호를 입력해 주세요.");
		return false;
	}
	return true;
}