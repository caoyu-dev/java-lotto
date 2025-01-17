package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoNumberList implements NumberList {

    private static final int START_UNIT = 0;
    private static final int END_UNIT = 6;

    @Override
    public List<LottoNumber> makeNumberList() {
        return sortNumber(getNumberList());
    }

    private static List<LottoNumber> sortNumber(List<Integer> numberList) {
        List<LottoNumber> sortedNumber = numberList.stream()
                .sorted(Integer::compareTo)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return Collections.unmodifiableList(sortedNumber);
    }

    private static List<Integer> getNumberList() {
        List<Integer> pickNumber = IntStream.range(LottoNumber.getStartNumber(), LottoNumber.getLastNumber())
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(pickNumber);

        return pickNumber.subList(START_UNIT, END_UNIT);
    }

}
