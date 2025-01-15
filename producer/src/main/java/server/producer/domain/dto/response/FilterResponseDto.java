package server.producer.domain.dto.response;

import lombok.Builder;

import java.util.List;

public record FilterResponseDto(
		List<HouseMapDto> houses // 매물 정보 리스트
) {
	@Builder
	public FilterResponseDto {
	}

	public record HouseMapDto(
			Long houseId,                 // 매물 ID
			Double x,                     // 위도
			Double y,                     // 경도
			String monthlyRent,           // 월세 범위
			String deposit,               // 보증금 범위
			String occupancyTypes,        // 인실 유형
			String location,              // 위치
			String genderPolicy,          // 성별 정책
			String locationDescription,   // 위치 설명
			Boolean isPinned,             // 즐겨찾기 여부
			String moodTag,               // 분위기 태그
			Integer contractTerm,         // 계약 기간
			String mainImgUrl             // 이미지 URL
	) {
		@Builder
		public HouseMapDto {
		}
	}
}