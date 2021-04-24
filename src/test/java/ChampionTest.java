import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    @Before
    public void setUp() {

        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("다리우스", "탑");
        Champion jungleChamp = new Champion("리신", "정글");
        Champion midChamp = new Champion("르블랑", "미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");

        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }

    //List<String>을 생성하고 값이 비어 있는지를 테스트 empty()
    @Test
    public void givenCollectionWhenEmptyCorrect() {
        List<String> emptyList = new ArrayList<>();
        assertThat(emptyList.size(), is(0));
    }

    //notNullValue 활용한 테스트
    @Test
    public void notNullCheck() {
        String lck = "LCK";
        assertNotNull(lck);
        System.out.println("result :: " + lck);
    }

    //nullValue 활용한 테스트
    @Test
    public void givenStringWhenNullIsCorrect() {
        String lck = null;
        assertThat(lck, nullValue());
    }

    //문자열 관련 테스트 anyOf, containsString, endWith
    @Test
    public void testForRelatedString() {
        String sampleString1 = "Player Focus";
        String sampleString2 = "Player point";
        String startString = "Player";
        String endString = "point";

        assertThat(sampleString1, allOf(containsString(startString), containsString(sampleString1)));
        //anyOf 인자로는 조건이 들어감.

        assertThat(sampleString1, containsString(startString));
        assertThat(sampleString2, containsString(startString));

        assertThat(sampleString2, Matchers.endsWith(endString));

        assertThat(sampleString1, Matchers.startsWith(startString));
        assertThat(sampleString2, Matchers.startsWith(startString));
    }

    //부동소수점 범위 closeTo 테스트
    @Test
    public void testForFloatingPoint() {
        double var1 = 2.45;
        double var2 = 3.12;
        double var3 = 10.15;

        assertThat(var1, closeTo(2.0, 0.5));
        assertThat(var2, closeTo(3.11, 0.02));
        assertThat(var3, closeTo(10.0, 0.2));
    }

    //anything 테스트
    @Test
    public void shouldNotErrorGetReference() {
        assertThat(championList.get(0), anything());
        System.out.println("championList 0번째 : " + championList.get(0));
    }

    //객체 크기 검증 테스트 hasSize
    @Test
    public void shouldChampionCountFive() {
        assertThat(championList, hasSize(5));
    }

    //타릭챔피언 객체를 만들고 이름과 포지션 검증
    @Test
    public void shouldSupportChampionIsTaric() {
        Champion supportChamp = new Champion("타릭", "바텀");
        championList.add(supportChamp);
        assertThat(supportChamp.getName() ,is("타릭"));
        assertThat(supportChamp.getPosition() ,is("바텀"));
        assertThat(supportChamp.getName(),equalTo(supportChamp.getName()));
    }

    //hasProperty 활용하여 속성이 포함되어 있는지 테스트
    @Test
    public void shouldHasPropertyPosition() {
        assertThat(championList.get(0), hasProperty("position", equalTo("탑")));
        assertThat(championList.get(0), hasProperty("name"));
    }

    //hasToString 활용 테스트
    @Test
    public void shouldHaveSomeChampName() {
        List<String> champListNames = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가느", "블라디미르");
        assertThat(champListNames.get(1), hasToString("애쉬"));
        assertThat(champListNames.get(0), containsString("시안"));
    }

    //property와 value가 같은지 테스트
    @Test
    public void shouldHaveSamePropertyAndValue() {
        List<String> championNames1 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> championNames2 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> champArr = championNames1;

        assertThat(championNames1, samePropertyValuesAs(championNames2));
        assertThat(championNames1, samePropertyValuesAs(champArr));
    }

    //탑 챔피언은 다리우스여야 한다라는 조건으로 테스트 코드 작성, stream 활용예
    @Test
    public void shouldTopChampionIsDarius() {
        Optional<Champion> filteredChampion = championList.stream()
                .filter(c -> c.getPosition().equals("탑"))
                .findFirst();
        assertThat(filteredChampion.get().getName(), is("다리우스"));
        assertTrue(filteredChampion.get().getPosition().equals("탑"));
        System.out.println("champ :: " + filteredChampion);
    }

}