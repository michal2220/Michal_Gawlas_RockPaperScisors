import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RockPapersScissorsTestSuite {

    @Test
    public void testingName() {
        //Given
        Input inputMock = mock(Input.class);
        Player player = new Player();

        //When
        when(inputMock.scanString()).thenReturn("Michal");
        String expectations = player.whatIsPlayersName(inputMock);

        //Then
        assertEquals("Michal", expectations);
    }

    @Test
    public void testingGameQuantity() {
        //Given
        Input inputMock = mock(Input.class);
        GamesQuantityReceiver gamesQuantityReceiver = new GamesQuantityReceiver(inputMock);

        //When
        when(inputMock.scanInt()).thenReturn(4);
        int expectations = gamesQuantityReceiver.howManyGames();

        //Then
        assertEquals(4, expectations);
    }

    @Test
    public void testingEndingGameByPlayer() {
        //Given

        Input inputMock = mock(Input.class);
        GamesQuantityReceiver gamesQuantityReceiver = new GamesQuantityReceiver(inputMock);
        FinishCondition finishCondition = new FinishCondition(inputMock , gamesQuantityReceiver);

        //When
        when(inputMock.getScanLine()).thenReturn("x");
        when(inputMock.scanString()).thenReturn("y");
        boolean expectations = finishCondition.checkingToContinue();

        //Then
        assertTrue(expectations);
    }
}
