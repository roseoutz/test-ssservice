package guide.triple.mileage.domain.entity;

import guide.triple.mileage.common.converter.BooleanToStringConverter;
import guide.triple.mileage.domain.entity.composite.MileageId;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

/**
 * packageName    : guide.triple.mileage.entity
 * fileName       : MileageReviewEntity
 * author         : kimdonggyuuuuu
 * date           : 2022/06/30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/06/30        kimdonggyuuuuu       최초 생성
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(MileageId.class)
@Entity
@Table(
        name = "triple_mileage_review",
        indexes = {
                @Index(
                        name = "idx_review_place_id",
                        columnList = "place_id"
                ),
                @Index(
                        name = "idx_review_pk",
                        columnList = "place_id, user_id"
                )
        }
)
public class MileageReviewEntity {

    @Id
    @Column(name = "user_id", length = 36)
    private String userId;

    @Id
    @Column(name = "place_id", length = 36)
    private String placeId;

    @Column(name = "review_id", length = 36, nullable = false)
    private String reviewId;

    @Convert(converter= BooleanToStringConverter.class)
    @Column(name = "text", length = 1)
    private boolean text = false;

    @Convert(converter=BooleanToStringConverter.class)
    @Column(name = "image", length = 1)
    private boolean image = false;

    @Convert(converter=BooleanToStringConverter.class)
    @Column(name = "bonus", length = 1)
    private boolean bonus = false;

    @Column(name="insert_time")
    protected long insertTime = System.currentTimeMillis();

    @Column(name="update_time")
    protected long updateTime = this.insertTime;

    @PreUpdate
    public void preUpdate() {
        updateTime = System.currentTimeMillis();
    }

}
