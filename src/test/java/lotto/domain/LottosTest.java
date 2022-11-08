package lotto.domain;

import lotto.strategy.AutoNumberList;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    private static final BigDecimal SMALL_THING = BigDecimal.valueOf(100);
    private static final BigDecimal BIG_THING = BigDecimal.valueOf(2000);

    @Test
    void generate_Number_of_tickets() {
        BigDecimal amount = BigDecimal.valueOf(14000);

        Lottos lottos = new Lottos(amount);
        lottos.buyLottos(lottos.getNumberOfTickets(amount), new AutoNumberList());

        assertThat(lottos.getLottoList()).hasSize(14);
    }

    @Test
    void test_Throw_IllegalArgumentException_If_A_is_smaller_than_Default_amount() {
        assertThatThrownBy(() -> new Lottos(SMALL_THING))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test_return_B_If_B_is_bigger_than_Default_amount() {
        Lottos lottos = new Lottos(BIG_THING);
        assertThat(lottos.getAmount()).isEqualTo(BIG_THING);
    }

    @Test
    void test_True_If_A_is_smaller_than_B() {
        assertThat(SMALL_THING.compareTo(BIG_THING)).isEqualTo(-1);
    }

    @Test
    void test_False_If_A_is_smaller_than_B() {
        assertThat(SMALL_THING.compareTo(BIG_THING) < -1).isFalse();
    }

    @Test
    void test() {
        if (true) {
            System.out.println("true!");
        }
    }
}
