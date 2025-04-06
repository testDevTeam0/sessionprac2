## 💡 나만의 Controller 만들기

> `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`을 활용한 RESTful API 실습

---
<br>

## ✨ HTTP 메서드 요약

| 메서드 | 설명 | 예시 |
|--------|------|------|
| **GET** | 데이터 조회 | 회원 정보 보기 |
| **POST** | 새 데이터 생성 | 회원가입, 글쓰기 |
| **PUT** | 기존 데이터 수정 | 회원 정보 수정 |
| **DELETE** | 데이터 삭제 | 회원 탈퇴 |

<br>

## 📌 전체 흐름

1. ✅ **요청 DTO 생성**  
   → JSON 데이터를 자바 객체로 매핑하기 위해 `MemberRequestDto` 작성

2. ✅ **Member 클래스 정의**  
   → 서버 내부에서 사용할 데이터 구조 (`Member` 객체에 값 저장)

3. ✅ **요청 DTO → Member 변환 및 처리**  
   → POST/PUT 시 `new Member(...)`로 객체 생성 및 수정

4. ✅ **응답 DTO 생성 및 반환**  
   → GET 시 `MemberResponseDto`를 통해 JSON 형식으로 응답  
   → POST/PUT/DELETE는 처리 완료 메시지 또는 응답 객체 반환

<br>

## ✔️ JSON은 무엇인가?

프론트엔드(Vue, React), 모바일 앱, 서버 간 통신에서  
**공식처럼 쓰이는 표준 데이터 포맷**입니다.

Spring에서는 객체를 자동으로 JSON 형태로 변환해주는 기능(Jackson)을 기본 제공하며,  
이를 활용해 `ResponseDto`를 리턴하면 **자동으로 JSON 응답이 생성**됩니다. 😎
<br>
<br>


## 📦 Member 클래스

❗이번 과제는 DB를 사용하지 않기 때문에,  
**POST 요청으로 받은 데이터를 임시로 저장할 수 있도록**  
`Member` 클래스를 직접 만들어 내부 저장소처럼 사용했습니다.

- **getter만 존재**  
  → 외부에서 수정할 필요가 없기 때문에 `setter`는 제외  
  → 값을 “읽기”만 하면 되는 구조!

- **@JsonProperty 사용**  
  → JSON 필드명이 `phone_number`인 데이터를  
     Java 필드인 `phoneNumber`에 매핑해주기 위해 사용!

<br>

## 📘 DTO에서 getter, setter는 언제 써야 할까?

> RequestDto / ResponseDto 각각의 **용도에 따라 다르게 사용됨**

| DTO 종류        | getter         | setter         |
|----------------|----------------|----------------|
| `RequestDto`   | 써도 되고 ✅   | **필수** ✅    |
| `ResponseDto`  | **필수** ✅    | 써도 됨 ☑️     |

<br>

## 📌 POST, GET, PUT, DELETE 코드

### 🟢 POST - 정보 생성
POST 요청으로 전달된 사용자 정보를 `Member` 객체에 저장하고  
`MemberResponseDto`로 변환하여 반환

---

### 🔵 GET - 정보 조회  
임시로 저장된 정보를 가져와서 JSON 형식으로 응답  
`MemberResponseDto`로 변환하여 반환

---

### 🟡 PUT - 정보 수정  
POST와 같은 방식으로 새로운 데이터를 받아  
`Member` 객체를 덮어쓰며 수정 후 반환

---

### 🔴 DELETE - 정보 삭제  
저장된 회원 정보를 지우고 `"삭제 완료"` 메시지를 문자열로 반환

<br>

## ✅ 실행 결과 예시

POST 요청으로 사용자 정보를 전달한 후,  
GET 요청으로 아래와 같은 JSON 형식의 응답을 확인할 수 있습니다.

```json
{
  "name": "우승연",
  "email": "seungyeon3287@gmail.com",
  "age": 26,
  "address": "seoul",
  "phone_number": "010-1234-5678"
}
```
## 📸 Talend API Tester 화면

요청과 응답은 Talend API Tester를 통해 확인했습니다.

### ✅ POST 요청 결과
사용자 정보를 전달하여 회원 생성
![image](https://github.com/user-attachments/assets/18dde09b-88b0-46af-ab74-69f1d506be40)


### ✅ GET 요청 결과  
생성된 회원 정보를 JSON 형태로 응답
![image](https://github.com/user-attachments/assets/b881725e-cf41-473f-b34d-aaeffa2ba519)


### ✅ PUT 요청 결과  
전화번호를 수정하여 정보 업데이트
![image](https://github.com/user-attachments/assets/d6afcdcb-7e53-4e96-9663-84c4a971c6ad)



### ✅ DELETE 요청 결과  
회원 정보를 삭제한 뒤 반환 메시지 확인
![image](https://github.com/user-attachments/assets/f3edffd2-fb3d-4b4a-9f32-c0ef44869c32)
