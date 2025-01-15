package server.producer.domain.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import server.producer.common.dto.ApiResponseDto;
import server.producer.common.dto.enums.ErrorCode;
import server.producer.common.dto.enums.SuccessCode;
import server.producer.domain.dto.response.HouseDetailsResponseDto;
import server.producer.domain.dto.response.MoodHouseResponseDto;
import server.producer.domain.service.HouseService;

@RestController
@RequestMapping("/v1/houses")
@RequiredArgsConstructor
public class HouseController {
    private final HouseService houseService;

    private final Long userId = 1L;

    @GetMapping("/{houseId}/details")
    public ApiResponseDto<HouseDetailsResponseDto> getHouseDetails(@PathVariable Long houseId) {
        try{
            HouseDetailsResponseDto responseDto = houseService.getHouseDetails(houseId, userId);
            return ApiResponseDto.success(SuccessCode.HOUSE_GET_SUCCESS, responseDto);
        } catch (Exception e){
            return ApiResponseDto.fail(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }
	@GetMapping
	public ApiResponseDto<MoodHouseResponseDto> getHousesByMoodAndLocation(@RequestParam String moodTag) {
		try {
			MoodHouseResponseDto moodHousesDto = houseService.getHousesByMoodAndLocation(moodTag, userId);
			return ApiResponseDto.success(SuccessCode.HOUSE_GET_SUCCESS, moodHousesDto);
		} catch (Exception e) {
			return ApiResponseDto.fail(ErrorCode.NOT_FOUND_HOUSE);
		}
	}

    @PatchMapping("/{houseId}/pins")
    public ApiResponseDto<Boolean> pinHouse(@PathVariable Long houseId) {
        try {
            boolean isPinned = houseService.togglePin(userId, houseId);
            return ApiResponseDto.success(SuccessCode.PIN_TOGGLE_SUCCESS, isPinned);
        } catch (Exception e) {
            return ApiResponseDto.fail(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }
}
