package lotto.domain;

import lotto.utils.AutoNumberList;
import lotto.utils.Tickets;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottos {

    private final BigDecimal amount;
    private List<Lotto> lottoList;

    public Lottos(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getNumberOfTickets(BigDecimal amount) {
        return Tickets.getNumberOfTickets(amount);
    }

    public Lottos buyLottos(int tryNum) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < tryNum; i++) {
            lottoList.add(
                    new Lotto(AutoNumberList.makeNumberList())
            );
        }

        this.lottoList = lottoList;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos = (Lottos) o;
        return Objects.equals(amount, lottos.amount) && Objects.equals(lottoList, lottos.lottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, lottoList);
    }

    @Override
    public String toString() {
        return "Lottos{" +
                "amount=" + amount +
                ", lottoList=" + lottoList +
                '}';
    }
}
