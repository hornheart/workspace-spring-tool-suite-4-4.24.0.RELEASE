function join_form_validation_submit_button() {

	/*
	DOM Tree에있는 form엘레멘트객체에 접근하는방법
		1. window.document.form태그의name속성값
		   ex> window.document.joinForm
		2. window.document.forms배열객체[index]
		   ex> window.document.forms[0]
		3. document객체의 getElementById()메쏘드를 사용해서 form객체검색
		   ex> document.getElementById("form태그id속성값");
			 - HTML Tag
				 <form id='joinForm'>
				 </form>
				 (엘레멘트의 아이디는 HTML파일안에서 유일해야됩니다.)
			 - javascript
				   var joinFormObject = document.getElementById('joinForm');
				 (DOM Tree에서 id가 joinForm인 엘레멘트객체를반환) 
		   
	form객체안에있는 input엘레멘트객체접근방법
		1.form객체.input태그의이름
		   ex> window.document.joinForm.id
		
	 */
	let f = document.getElementById('joinForm');
	if (f.id.value === "") {
		//alert('아이디를 입력하세요');
		let idSpan = document.getElementById('idMessage');
		idSpan.innerHTML = 'ID 입력하세요';
		f.id.focus();
		return false;
	}

	if (f.password.value === "") {
		alert('패쓰워드를 입력하세요');
		f.password.focus();
		return false;
	}
	if (f.repassword.value === "") {
		alert('패쓰워드확인을 입력하세요');
		f.repassword.focus();
		return false;
	}

	if (f.name.value === "") {
		alert('이름을 입력하세요');
		f.name.focus();
		return false;
	}

	if (f.address.value === "") {
		alert('주소를 입력하세요');
		f.address.focus();
		return false;
	}
	if (!isSame(f.password.value, f.repassword.value)) {
		alert('패쓰워드와 패쓰워드확인은 일치해야합니다.');
		f.password.select();
		return false;
	}
	return true;

	/*
	1.아이디는 5~10자여야한다
	2.영문알파벳대문자,소문자,숫자만 가능
	3.아이디의 첫글자는 영문알파벳대문자,소문자만 가능합니다(숫자로 시작할수없다)
	 */

}
function join_form_validation_button() {
	// validation
	let f = document.getElementById('joinForm');
	if (f.id.value === "") {
		let idSpan = document.getElementById('idMessage');
		idSpan.innerHTML = 'ID 입력하세요';
		f.id.focus();
		return;
	}

	if (f.password.value === "") {
		alert('패쓰워드를 입력하세요');
		f.password.focus();
		return;
	}
	if (f.repassword.value === "") {
		alert('패쓰워드확인을 입력하세요');
		f.repassword.focus();
		return;
	}

	if (f.name.value === "") {
		alert('이름을 입력하세요');
		f.name.focus();
		return;
	}

	if (f.address.value === "") {
		alert('주소를 입력하세요');
		f.address.focus();
		return;
	}
	if (f.password.value != f.repassword.value) {
		alert('패쓰워드와 패쓰워드확인은 일치해야합니다.');
		f.password.select();
		return;
	}
	f.action = 'join_action.jsp';
	f.method = 'POST';
	f.submit();
	return;
	/*
	1.아이디는 5~10자여야한다
	2.영문알파벳대문자,소문자,숫자만 가능
	3.아이디의 첫글자는 영문알파벳대문자,소문자만 가능합니다(숫자로 시작할수없다)
	 */

}