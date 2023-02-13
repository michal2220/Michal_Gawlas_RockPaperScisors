import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RockPapersScissorsTestSuite {

    SimpleText text = new SimpleText();

    @Test
    public void testingName() {
        //Given
        Input inputMock = mock(Input.class);
        Player player = new Player();

        //When
        when(inputMock.scanString()).thenReturn("Michal");
        String expectations = player.whatIsPlayersName(inputMock, text);

        //Then
        assertEquals("Michal", expectations);
    }

    @Test
    public void testingGameQuantity() {
        //Given
        Input inputMock = mock(Input.class);
        Game game = new Game();

        //When
        when(inputMock.scanInt()).thenReturn(4);
        int expectations = game.howManyGames(inputMock, text);

        //Then
        assertEquals(4, expectations);
    }

    @Test
    public void testingEndingGameByPlayer() {
        //Given

        Input inputMock = mock(Input.class);
        FinishCondition finishCondition = new FinishCondition(inputMock);

        //When
        when(inputMock.scanString()).thenReturn("n");
        boolean expectations = finishCondition.checkingToContinue();

        //Then
        assertTrue(expectations);
    }
}
