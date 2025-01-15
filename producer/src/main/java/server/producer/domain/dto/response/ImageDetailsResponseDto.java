package server.producer.domain.dto.response;

import lombok.Builder;
import java.util.List;

public record ImageDetailsResponseDto(
        ImagesDto images
) {
    @Builder
    public ImageDetailsResponseDto{
    }
    public record ImagesDto(
            List<String> mainImgUrls,
            String mainImgDescription,
            List<String> facilityImgUrls,
            String facilityImgDescription,
            List<String> floorImgUrls
    ){
        @Builder
        public ImagesDto{
        }
    }
}
