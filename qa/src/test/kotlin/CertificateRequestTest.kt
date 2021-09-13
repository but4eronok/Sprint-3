import io.mockk.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.sber.qa.Certificate
import ru.sber.qa.CertificateRequest
import ru.sber.qa.CertificateType
import ru.sber.qa.Scanner
import kotlin.random.Random
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class CertificateRequestTest {

    private val certificateType = mockk<CertificateType>()
    private val certificate = mockk<Certificate>()
    private val certificateRequest = CertificateRequest(10L, certificateType)

    @Test
    fun `same variables`() {
        //given
        val employeeNumber = 10L

        //then
        assertEquals(employeeNumber, certificateRequest.employeeNumber)
        assertEquals(certificateType, certificateRequest.certificateType)

    }

    @Test
    fun `same certificateType`() {
        assertEquals(certificateType, certificateRequest.certificateType)
    }

    @Test
    fun `same processedBy`() {
        //given
        val hrEmployeeNumber = 10L
        every { certificate.processedBy } returns 10L

        //then
        assertEquals(certificate.processedBy, hrEmployeeNumber)
    }

    @Test
    fun `same data`() {
        //given
        val data = ByteArray(10)
        every { certificate.data } returns data

        //then
        assertEquals(data, certificate.data)
    }

    @AfterEach
    fun afterTests() {
        unmockkAll()
    }
}