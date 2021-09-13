import io.mockk.*
import org.junit.jupiter.api.*
import ru.sber.qa.*
import java.time.*

class HrDepartmentTest {
    private val certificateRequest = mockk<CertificateRequest>()

    @BeforeEach
    fun beforeTests() {
        mockkObject(HrDepartment)
        mockkStatic(LocalDateTime::class)

    }

    @Test
    fun `throwing WeekendDayException`() {
        //given
        every { LocalDateTime.now(Clock.systemUTC()).dayOfWeek } returns DayOfWeek.SUNDAY

        //then
        assertThrows<WeekendDayException> { HrDepartment.receiveRequest(certificateRequest) }
    }

    @Test
    fun `throwing NotAllowReceiveRequestException NDFL`() {
        //given
        every { LocalDateTime.now(Clock.systemUTC()).dayOfWeek } returns DayOfWeek.MONDAY
        every { certificateRequest.certificateType } returns CertificateType.LABOUR_BOOK

        //then
        assertThrows<NotAllowReceiveRequestException> { HrDepartment.receiveRequest(certificateRequest) }
    }

    @Test
    fun `throwing NotAllowReceiveRequestException LABOUR_BOOK`() {
        //given
        every { LocalDateTime.now(Clock.systemUTC()).dayOfWeek } returns DayOfWeek.TUESDAY
        every { certificateRequest.certificateType } returns CertificateType.NDFL

        //then
        assertThrows<NotAllowReceiveRequestException> { HrDepartment.receiveRequest(certificateRequest) }
    }

    @Test
    fun `receiveRequest run without error with NDFL`() {
        //given
        every { LocalDateTime.now(Clock.systemUTC()).dayOfWeek } returns DayOfWeek.MONDAY
        every { certificateRequest.certificateType } returns CertificateType.NDFL

        //then
        assertDoesNotThrow { HrDepartment.receiveRequest(certificateRequest) }
    }

    @Test
    fun `receiveRequest run without error with LABOUR_BOOK`() {
        //given
        every { LocalDateTime.now(Clock.systemUTC()).dayOfWeek } returns DayOfWeek.TUESDAY
        every { certificateRequest.certificateType } returns CertificateType.LABOUR_BOOK

        //then
        assertDoesNotThrow { HrDepartment.receiveRequest(certificateRequest) }
    }

    @AfterEach
    fun afterTests() {
        unmockkAll()
    }
}