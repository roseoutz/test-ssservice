package guide.triple.mileage.domain.entity.composite;

import lombok.*;

import java.io.Serializable;

/**
 * packageName    : guide.triple.mileage.entity.composite
 * fileName       : MileageId
 * author         : kimdonggyuuuuu
 * date           : 2022/06/30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/06/30        kimdonggyuuuuu       최초 생성
 */
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MileageId implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String placeId;

}
