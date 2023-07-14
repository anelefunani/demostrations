package za.co.code.caloriescounting.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Calorie implements Comparable<Calorie> {
    int amount;

    @Override
    public int compareTo(Calorie other) {
        return  other.amount - this.amount;
    }
}
