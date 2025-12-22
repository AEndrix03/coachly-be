package it.coachly.api.service.user.data;

import com.querydsl.core.annotations.QueryProjection;
import it.coachly.api.model.user.QUserInfo;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
public class UserDto {

    private UUID id;
    private String username;

    @QueryProjection
    public UserDto(UUID id, String username) {
        this.id = id;
        this.username = username;
    }

    public static QUserDto getProjection() {
        QUserInfo qUI = QUserInfo.userInfo;
        return new QUserDto(
                qUI.userId,
                qUI.username
        );
    }

}
