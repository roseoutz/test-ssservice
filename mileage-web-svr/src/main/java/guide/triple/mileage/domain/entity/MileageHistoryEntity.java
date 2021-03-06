package guide.triple.mileage.domain.entity;

import guide.triple.mileage.common.constant.ActionType;
import guide.triple.mileage.common.converter.BooleanToStringConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

/**
 * packageName    : guide.triple.mileage.entity
 * fileName       : MileageEntity
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
@Entity
@Table(
        name = "triple_mileage_history",
        indexes = {
                @Index(
                        name = "idx_history_userId",
                        columnList = "user_id"
                )
        }
)
public class MileageHistoryEntity {

    @Id
    @Column(name = "oid", length = 36)
    private String oid;

    @Column(name = "user_id", length = 36, nullable = false)
    private String userId;

    @Column(name = "place_id", length = 36, nullable = false)
    private String placeId;

    @Column(name = "review_id", length = 36, nullable = false)
    private String reviewId;

    @Enumerated(EnumType.STRING)
    @Column(name = "action_type", length = 10, nullable = false)
    private ActionType actionType;

    @Column(name = "text_point")
    private long textPoint = 0;

    @Column(name = "image_point")
    private long imagePoint = 0;

    @Column(name = "bonus_point")
    private long bonusPoint = 0;

    @Column(name = "earned_point")
    private long earnedPoint = 0;

    @Column(name="insert_time")
    protected long insertTime = System.currentTimeMillis();

    @Column(name="update_time")
    protected long updateTime = this.insertTime;

    @PrePersist
    public void prePersist() {
        oid = UUID.randomUUID().toString();
    }

    @PreUpdate
    public void preUpdate() {
        updateTime = System.currentTimeMillis();
    }

}
