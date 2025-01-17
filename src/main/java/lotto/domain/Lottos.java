package lotto.domain;

import lotto.strategy.NumberList;
import lotto.utils.Tickets;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Lottos {

    private static final BigDecimal DEFAULT_AMOUNT = BigDecimal.valueOf(1000);
    private final BigDecimal amount;
    private List<Lotto> lottoLists;

    public Lottos(BigDecimal amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private static void validateAmount(BigDecimal amount) {
        if (amount.compareTo(DEFAULT_AMOUNT) == -1) {
            throw new IllegalArgumentException("천 원 이상 내세요.");
        }
    }

    public static boolean getRank(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            if (Rank.getResultRank(lotto).equals(Rank.SECOND)) {
                return true;
            }
            if (Rank.getResultRank(lotto).equals(Rank.THIRD)) {
                return false;
            }
        }
        return false;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public List<Lotto> getLottoList() {
        return lottoLists;
    }

    public int getNumberOfTickets(BigDecimal amount) {
        return Tickets.getNumberOfTickets(amount);
    }

    public Lottos buyLottos(List<Lotto> lottoList, int tryNum, NumberList numberList) {
        for (int i = 0; i < tryNum; i++) {
            lottoList.add(
                    new Lotto(numberList.makeNumberList())
            );
        }

        this.lottoLists = lottoList;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos = (Lottos) o;
        return Objects.equals(amount, lottos.amount) && Objects.equals(lottoLists, lottos.lottoLists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, lottoLists);
    }
}
