package server.producer.common.dto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

	//400 Bad Request
	BAD_REQUEST(40000, "유효한 요청이 아닙니다."),
	MISSING_REQUIRED_HEADER(40001, "필수 헤더가 누락되었습니다."),
	MISSING_REQUIRED_PARAMETER(40002, "필수 파라미터가 누락되었습니다."),
	INVALID_PARAMETER(40003, "유효하지 않은 파라미터입니다."),
	//403 Forbidden
	ACCESS_DENIED(40300, "권한이 없습니다."),
	//404 Not Found
	NOT_FOUND(40400, "존재하지 않는 API입니다."),
	NOT_FOUND_HOUSE(40401, "존재하지 않는 매물 ID 입니다."),
	HOUSE_NOT_FOUND(40402, "존재하지 않는 매물입니다."),
	ROOM_NOT_FOUND(40403, "존재하지 않는 방입니다"),
	//405 Method Not Allowed
	METHOD_NOT_ALLOWED(40500, "해당 요청은 지원되지 않습니다."),
	//500 Internal Server Error
	INTERNAL_SERVER_ERROR(50000, "서버 내부 오류입니다."),
	//503 Service Unavailable
	SERVICE_UNAVAILABLE(50300, "서비스를 이용할 수 없습니다.");

	private final int code;
	private final String message;
}