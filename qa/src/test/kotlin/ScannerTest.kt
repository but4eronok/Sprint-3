import io.mockk.every
import io.mockk.mockkObject
import io.mockk.unmockkAll
import org.junit.jupiter.api.*
import ru.sber.qa.ScanTimeoutException
import ru.sber.qa.Scanner
import kotlin.random.Random

class ScannerTest {

    @BeforeEach
    fun beforeTests() {
        mockkObject(Random)
    }

    @Test
    fun `throwing ScamTimeoutException`() {

        every { Random.nextLong(5000L, 15000L) } returns 200000L
        assertThrows<ScanTimeoutException> { Scanner.getScanData() }
    }

    @Test
    fun `not throwing ScamTimeoutException`() {
        every { Random.nextLong(5000L, 15000L) } returns 5001L
        assertDoesNotThrow { Scanner.getScanData() }
    }

    @AfterEach
    fun afterTests() {
        unmockkAll()
    }
}