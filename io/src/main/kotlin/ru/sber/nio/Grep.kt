package ru.sber.nio

import jdk.incubator.foreign.MemorySegment.READ
import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.nio.file.Files
import java.nio.file.Files.*
import java.nio.file.Paths
import java.util.*
import kotlin.io.path.bufferedWriter
import kotlin.io.path.isRegularFile
import kotlin.io.path.name
import kotlin.io.path.useLines

/**
 * Реализовать простой аналог утилиты grep с использованием калссов из пакета java.nio.
 */
class Grep {

    fun find(subString: String) {
        val path = Paths.get("io/logs")
        val programResult = Paths.get("io/result.txt")

        programResult.bufferedWriter().use { buff ->
            find(path, 10, { p, _ -> p.toString().endsWith(".log") }).forEach { logs ->
                logs.useLines { lines ->
                    lines.filter { currLine ->
                        currLine.contains(subString)
                    }.forEach { subString ->
                        buff.write("${logs.name} : ${logs.useLines { it.indexOf(subString) } + 1} : $subString")
                    }
                }
            }
        }
    }
}
