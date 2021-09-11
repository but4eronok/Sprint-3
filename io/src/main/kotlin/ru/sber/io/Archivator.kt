package ru.sber.io

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import java.util.zip.ZipOutputStream


class Archivator {
    val file = File("io\\logfile.log")
    val zip = File("io\\logfile.zip")
    val unzippedFile = File("io\\unzipped log file.log")

    fun zipLogfile() {
        var fis: InputStream? = null
        var zos: ZipOutputStream? = null
        try {
            fis = FileInputStream(file)
            zos = ZipOutputStream(FileOutputStream(zip))
            zos.putNextEntry(ZipEntry(file.name))
            var readByte = fis.read()
            while (readByte != -1) {
                zos.write(readByte)
                readByte = fis.read()
            }
        } finally {
            fis?.close()
            zos?.close()
        }
    }

    fun unzipLogfile() {
        var zis: ZipInputStream? = null
        var fos: FileOutputStream? = null
        try {
            zis = ZipInputStream(FileInputStream(zip))
            fos = FileOutputStream(unzippedFile)
            zis.nextEntry
            var readByte = zis.read()
            while (readByte != -1) {
                fos.write(readByte)
                readByte = zis.read()
            }
        } finally {
            zis?.close()
            fos?.close()
        }
    }
}

