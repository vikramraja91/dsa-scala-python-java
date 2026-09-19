package org.dsa

import scala.collection.mutable
import scala.util.{Try, Success, Failure}

/**
* Scala Built-in Functions / Collections Worksheet
*
* Purpose:
  * Learn and practice the most useful Scala built-in functions
    * for DSA, Data Engineering, Spark and interview preparation.
*
* Run this file as a Scala application.
*/
object ScalaBuiltinsWorksheet extends App {

  // ============================================================
  // BASIC VALUES
  // ============================================================

  val number = 10
  val decimal = 10.5
  val name = "Scala"
  val flag = true

  println(number)
  println(decimal)
  println(name)
  println(flag)


  // ============================================================
  // ARRAY
  // ============================================================

  val arr = Array(5, 2, 8, 1, 3, 2)

  // length
  println(arr.length)

  // head - first element
  println(arr.head)

  // last - last element
  println(arr.last)

  // headOption - safe first element
  println(arr.headOption)

  // lastOption - safe last element
  println(arr.lastOption)

  // apply / index access
  println(arr(0))

  // update
  arr(0) = 100
  println(arr.mkString(", "))

  // isEmpty
  println(arr.isEmpty)

  // nonEmpty
  println(arr.nonEmpty)

  // contains
  println(arr.contains(8))

  // indexOf
  println(arr.indexOf(8))

  // indexWhere
  println(arr.indexWhere(_ > 5))

  // find
  println(arr.find(_ > 5))

  // exists - at least one matches
  println(arr.exists(_ > 10))

  // forall - all match
  println(arr.forall(_ > 0))

  // count
  println(arr.count(_ % 2 == 0))


  // ============================================================
  // MAP
  // ============================================================

  // Transform every element
  val doubled = arr.map(x => x * 2)

  // Short syntax
  val tripled = arr.map(_ * 3)

  println(doubled.mkString(", "))
  println(tripled.mkString(", "))


  // ============================================================
  // FILTER
  // ============================================================

  val even = arr.filter(_ % 2 == 0)

  val odd = arr.filter(_ % 2 != 0)

  println(even.mkString(", "))
  println(odd.mkString(", "))


  // filterNot
  val notEven = arr.filterNot(_ % 2 == 0)

  println(notEven.mkString(", "))


  // ============================================================
  // FOREACH
  // ============================================================

  arr.foreach(x => println(x))

  // Short syntax
  arr.foreach(println)


  // ============================================================
  // REDUCE
  // ============================================================

  val reduceSum = arr.reduce(_ + _)
  val reduceProduct = arr.reduce(_ * _)
  val reduceMax = arr.reduce(_ max _)
  val reduceMin = arr.reduce(_ min _)

  println(reduceSum)
  println(reduceProduct)
  println(reduceMax)
  println(reduceMin)


  // ============================================================
  // REDUCELEFT / REDUCERIGHT
  // ============================================================

  val numbers = List(1, 2, 3, 4)

  println(numbers.reduceLeft(_ - _))
  println(numbers.reduceRight(_ - _))


  // ============================================================
  // FOLD
  // ============================================================

  val foldSum = numbers.fold(0)(_ + _)

  println(foldSum)

  val foldProduct = numbers.fold(1)(_ * _)

  println(foldProduct)

  val foldMax = numbers.fold(Int.MinValue)(_ max _)

  println(foldMax)

  val foldMin = numbers.fold(Int.MaxValue)(_ min _)

  println(foldMin)


  // ============================================================
  // FOLDLEFT
  // ============================================================

  val foldLeftSum = numbers.foldLeft(0)(_ + _)

  println(foldLeftSum)

  val foldLeftString =
    numbers.foldLeft("")((result, x) => result + x)

  println(foldLeftString)


  // ============================================================
  // FOLDRIGHT
  // ============================================================

  val foldRightResult =
    numbers.foldRight(0)(_ + _)

  println(foldRightResult)


  // ============================================================
  // SUM / PRODUCT / MIN / MAX
  // ============================================================

  println(numbers.sum)
  println(numbers.product)
  println(numbers.min)
  println(numbers.max)


  // ============================================================
  // SORTING
  // ============================================================

  val unsorted = Array(5, 1, 8, 2, 3)

  // Ascending
  println(unsorted.sorted.mkString(", "))

  // Descending
  println(unsorted.sorted.reverse.mkString(", "))

  // sortWith
  println(unsorted.sortWith(_ < _).mkString(", "))

  println(unsorted.sortWith(_ > _).mkString(", "))


  // ============================================================
  // SORT BY
  // ============================================================

  val people = List(
    ("Raja", 30),
    ("John", 25),
    ("Sam", 40)
  )

  // Sort by age
  println(people.sortBy(_._2))

  // Sort by name
  println(people.sortBy(_._1))

  // Descending
  println(people.sortBy(_._2).reverse)

  // maxBy
  println(people.maxBy(_._2))

  // minBy
  println(people.minBy(_._2))


  // ============================================================
  // REVERSE
  // ============================================================

  println(numbers.reverse)


  // ============================================================
  // DISTINCT
  // ============================================================

  val duplicates = List(1, 2, 2, 3, 3, 3)

  println(duplicates.distinct)


  // ============================================================
  // TAKE / DROP
  // ============================================================

  val values = List(10, 20, 30, 40, 50)

  println(values.take(3))
  println(values.drop(3))

  println(values.takeRight(2))
  println(values.dropRight(2))


  // ============================================================
  // TAKEWHILE / DROPWHILE
  // ============================================================

  val ordered = List(1, 2, 3, 6, 2, 4)

  println(ordered.takeWhile(_ < 5))
  println(ordered.dropWhile(_ < 5))


  // ============================================================
  // SLICE
  // ============================================================

  println(values.slice(1, 4))


  // ============================================================
  // SPLITAT
  // ============================================================

  val (leftPart, rightPart) = values.splitAt(2)

  println(leftPart)
  println(rightPart)


  // ============================================================
  // PARTITION
  // ============================================================

  val (evenNumbers, oddNumbers) =
    values.partition(_ % 2 == 0)

  println(evenNumbers)
  println(oddNumbers)


  // ============================================================
  // ZIP
  // ============================================================

  val names = List("Raja", "John", "Sam")
  val ages = List(30, 25, 40)

  val zipped = names.zip(ages)

  println(zipped)


  // ============================================================
  // ZIPWITHINDEX
  // ============================================================

  names.zipWithIndex.foreach {
    case (name, index) =>
      println(s"$index -> $name")
  }


  // ============================================================
  // UNZIP
  // ============================================================

  val personData =
    List(
      ("Raja", 30),
      ("John", 25),
      ("Sam", 40)
    )

  val (personNames, personAges) =
    personData.unzip

  println(personNames)
  println(personAges)


  // ============================================================
  // FLATTEN
  // ============================================================

  val nested =
    List(
      List(1, 2),
      List(3, 4),
      List(5, 6)
    )

  println(nested.flatten)


  // ============================================================
  // FLATMAP
  // ============================================================

  val flatMapped =
    List(1, 2, 3)
      .flatMap(x => List(x, x * 10))

  println(flatMapped)


  // ============================================================
  // COLLECT
  // ============================================================

  val collected =
    List(1, 2, 3, 4, 5)
      .collect {
        case x if x % 2 == 0 => x * 10
      }

  println(collected)


  // ============================================================
  // GROUPBY
  // ============================================================

  val grouped =
    List(1, 2, 3, 4, 5, 6)
      .groupBy(_ % 2)

  println(grouped)


  // ============================================================
  // FREQUENCY COUNT
  // ============================================================

  val frequencyInput =
    List(1, 2, 2, 3, 3, 3)

  val frequency =
    frequencyInput
      .groupBy(identity)
      .view
      .mapValues(_.size)
      .toMap

  println(frequency)


  // ============================================================
  // SLIDING WINDOW
  // ============================================================

  val windowArray =
    Array(2, 1, 5, 1, 3, 2)

  // Windows of size 3
  windowArray
    .sliding(3)
    .foreach(window => println(window.mkString(", ")))


  // Maximum sum of contiguous subarray of size k
  val k = 3

  val maximumWindowSum =
    windowArray
      .sliding(k)
      .map(_.sum)
      .max

  println(maximumWindowSum)


  // ============================================================
  // GROUPED
  // ============================================================

  println(
    List(1, 2, 3, 4, 5, 6)
      .grouped(2)
      .toList
  )


  // ============================================================
  // INITS / TAILS
  // ============================================================

  println(List(1, 2, 3).inits.toList)

  println(List(1, 2, 3).tails.toList)


  // ============================================================
  // COMBINATIONS / PERMUTATIONS
  // ============================================================

  val combinationInput =
    List(1, 2, 3)

  println(combinationInput.combinations(2).toList)

  println(combinationInput.permutations.toList)


  // ============================================================
  // LIST
  // ============================================================

  val list = List(1, 2, 3, 4)

  println(list.head)
  println(list.tail)
  println(list.last)

  // Prepend
  println(0 :: list)

  // Append
  println(list :+ 5)

  // Concatenate
  println(list ++ List(5, 6))


  // ============================================================
  // VECTOR
  // ============================================================

  val vector = Vector(1, 2, 3, 4)

  println(vector(0))
  println(vector.map(_ * 2))
  println(vector.filter(_ > 2))
  println(vector.updated(0, 100))


  // ============================================================
  // SET
  // ============================================================

  val setA = Set(1, 2, 3, 4)
  val setB = Set(3, 4, 5, 6)

  println(setA.contains(3))

  // Add
  println(setA + 10)

  // Remove
  println(setA - 2)

  // Union
  println(setA union setB)

  // Intersection
  println(setA intersect setB)

  // Difference
  println(setA diff setB)

  // Size
  println(setA.size)


  // ============================================================
  // MAP
  // ============================================================

  val scores =
    Map(
      "Raja" -> 90,
      "John" -> 80,
      "Sam" -> 70
    )

  // Get value
  println(scores.get("Raja"))

  // Safe default
  println(scores.getOrElse("Unknown", 0))

  // Contains key
  println(scores.contains("Raja"))

  // Keys
  println(scores.keys)

  // Values
  println(scores.values)

  // Map transformation
  println(scores.map {
    case (name, score) =>
      name -> (score + 5)
  })

  // Map iteration
  scores.foreach {
    case (name, score) =>
      println(s"$name -> $score")
  }


  // ============================================================
  // MUTABLE MAP
  // ============================================================

  val mutableMap =
    mutable.Map[Int, Int]()

  mutableMap(1) = 100
  mutableMap(2) = 200

  println(mutableMap)

  mutableMap.update(1, 500)

  println(mutableMap)

  mutableMap.remove(2)

  println(mutableMap)


  // ============================================================
  // MUTABLE SET
  // ============================================================

  val mutableSet =
    mutable.Set(1, 2, 3)

  mutableSet.add(4)

  mutableSet.remove(2)

  println(mutableSet)


  // ============================================================
  // STACK
  // ============================================================

  val stack =
    mutable.Stack[Int]()

  stack.push(10)
  stack.push(20)
  stack.push(30)

  println(stack)

  println(stack.pop())

  println(stack)


  // ============================================================
  // QUEUE
  // ============================================================

  val queue =
    mutable.Queue[Int]()

  queue.enqueue(10)
  queue.enqueue(20)
  queue.enqueue(30)

  println(queue)

  println(queue.dequeue())

  println(queue)


  // ============================================================
  // RANGE
  // ============================================================

  // Inclusive
  println(1 to 5)

  // Exclusive end
  println(1 until 5)

  // Step
  println(1 to 10 by 2)

  // Reverse
  println(10 to 1 by -1)

  // Range to collection
  println((1 to 5).toList)

  println((1 to 5).toArray)


  // ============================================================
  // STRING
  // ============================================================

  val text = "Hello Scala"

  println(text.length)

  println(text.head)

  println(text.last)

  println(text(0))

  println(text.charAt(0))

  println(text.isEmpty)

  println(text.nonEmpty)

  println(text.contains("Scala"))

  println(text.startsWith("Hello"))

  println(text.endsWith("Scala"))

  println(text.indexOf("Scala"))

  println(text.substring(0, 5))

  println(text.toUpperCase)

  println(text.toLowerCase)

  println(text.trim)

  println(text.replace("Scala", "Java"))


  // ============================================================
  // STRING SPLIT
  // ============================================================

  val csv =
    "apple,banana,orange"

  val fruits =
    csv.split(",")

  println(fruits.mkString(", "))


  // ============================================================
  // STRING -> CHARACTER ARRAY
  // ============================================================

  val characters =
    text.toCharArray

  println(characters.mkString(", "))


  // CHARACTER CHECKS
  // ============================================================

  val c = '7'

  println(c.isDigit)
  println(c.isLetter)
  println(c.isWhitespace)
  println(c.isUpper)
  println(c.isLower)


  // ============================================================
  // STRING FILTER
  // ============================================================

  println("abc123xyz456".filter(_.isDigit))

  println("abc123xyz456".filter(_.isLetter))


  // ============================================================
  // MKSTRING
  // ============================================================

  val output =
    List(1, 2, 3, 4)

  println(output.mkString(","))

  println(output.mkString(" "))

  println(output.mkString("[", ", ", "]"))


  // ============================================================
  // ITERATOR
  // ============================================================

  val iterator =
    List(1, 2, 3, 4, 5).iterator

  println(iterator.map(_ * 2).toList)


  // ============================================================
  // ITERATOR - LAZY OPERATIONS
  // ============================================================

  val lazyValues =
    List(1, 2, 3, 4, 5)
      .iterator
      .filter(_ % 2 == 0)
      .map(_ * 10)

  println(lazyValues.toList)


  // ============================================================
  // VIEW
  // ============================================================

  val view =
    List(1, 2, 3, 4, 5)
      .view
      .map(_ * 2)
      .filter(_ > 5)

  println(view.toList)


  // ============================================================
  // CONVERSION
  // ============================================================

  val listFromArray =
    arr.toList

  val vectorFromList =
    list.toVector

  val setFromList =
    list.toSet

  val arrayFromList =
    list.toArray

  println(listFromArray)
  println(vectorFromList)
  println(setFromList)
  println(arrayFromList.mkString(", "))


  // ============================================================
  // TUPLES
  // ============================================================

  val tuple2 =
    ("Raja", 30)

  println(tuple2._1)
  println(tuple2._2)


  val tuple3 =
    ("Raja", 30, "India")

  println(tuple3._1)
  println(tuple3._2)
  println(tuple3._3)


  // ============================================================
  // OPTION
  // ============================================================

  val maybeNumber: Option[Int] =
    Some(100)

  val noNumber: Option[Int] =
    None

  println(maybeNumber)

  println(noNumber)

  println(maybeNumber.getOrElse(0))

  println(noNumber.getOrElse(0))


  // map on Option
  println(maybeNumber.map(_ * 2))

  // filter on Option
  println(maybeNumber.filter(_ > 50))

  // foreach on Option
  maybeNumber.foreach(println)


  // ============================================================
  // OPTION + FIND
  // ============================================================

  val found =
    List(1, 2, 3, 4)
      .find(_ > 2)

  println(found)

  println(found.getOrElse(-1))


  // ============================================================
  // SOME / NONE PATTERN MATCHING
  // ============================================================

  found match {

    case Some(value) =>
      println(s"Found: $value")

    case None =>
      println("Not found")
  }


  // ============================================================
  // MATH FUNCTIONS
  // ============================================================

  println(math.abs(-10))

  println(math.max(10, 20))

  println(math.min(10, 20))

  println(math.pow(2, 3))

  println(math.sqrt(16))

  println(math.round(10.6))

  println(math.floor(10.9))

  println(math.ceil(10.1))

  println(math.PI)


  // ============================================================
  // BIGINT
  // ============================================================

  val bigNumber =
    BigInt("999999999999999999999999999999")

  println(bigNumber)

  println(bigNumber + 1)


  // ============================================================
  // BIGDECIMAL
  // ============================================================

  val preciseNumber =
    BigDecimal("123456789.123456789")

  println(preciseNumber)


  // ============================================================
  // FOR LOOP
  // ============================================================

  for (i <- 1 to 5) {
    println(i)
  }


  // ============================================================
  // FOR LOOP WITH CONDITION
  // ============================================================

  for (i <- 1 to 10 if i % 2 == 0) {
    println(i)
  }


  // ============================================================
  // FOR YIELD
  // ============================================================

  val squares =
    for {
      i <- 1 to 5
    } yield i * i

  println(squares)


  // ============================================================
  // FOR WITH MULTIPLE GENERATORS
  // ============================================================

  val combinations =
    for {
      i <- 1 to 3
      j <- 1 to 3
    } yield (i, j)

  println(combinations)


  // ============================================================
  // IF / ELSE
  // ============================================================

  val age = 30

  val category =
    if (age >= 18)
      "Adult"
    else
      "Minor"

  println(category)


  // ============================================================
  // MATCH
  // ============================================================

  val day = 2

  day match {

    case 1 =>
      println("Monday")

    case 2 =>
      println("Tuesday")

    case 3 =>
      println("Wednesday")

    case _ =>
      println("Other")
  }


  // ============================================================
  // PATTERN MATCHING WITH TUPLES
  // ============================================================

  val person =
    ("Raja", 30)

  person match {

    case (personName, personAge) =>
      println(s"$personName is $personAge")
  }


  // ============================================================
  // PATTERN MATCHING WITH COLLECTION
  // ============================================================

  List(1, 2, 3) match {

    case head :: tail =>
      println(s"head = $head")
      println(s"tail = $tail")

    case Nil =>
      println("Empty")
  }


  // ============================================================
  // CONS OPERATOR ::
  // ============================================================

  val original =
    List(2, 3, 4)

  val newList =
    1 :: original

  println(newList)


  // ============================================================
  // NIL
  // ============================================================

  val emptyList =
    Nil

  println(emptyList)

  println(emptyList.isEmpty)


  // ============================================================
  // STRING INTERPOLATION
  // ============================================================

  val userName = "Raja"
  val userAge = 30

  println(s"Name: $userName")
  println(s"Age: $userAge")

  println(
    s"$userName is $userAge years old"
  )

  // Expression inside interpolation
  println(s"Next year: ${userAge + 1}")


  // ============================================================
  // RAW INTERPOLATION
  // ============================================================

  println(raw"Hello\nScala")


  // ============================================================
  // MULTILINE STRING
  // ============================================================

  val multiline =
    """
      |This is
      |a multiline
      |string
    """.stripMargin

  println(multiline)


  // ============================================================
  // STRING BUILDER
  // ============================================================

  val builder =
    new StringBuilder

  builder.append("Hello")
  builder.append(" ")
  builder.append("Scala")

  println(builder.toString)

  builder.clear()

  builder.append("New Text")

  println(builder.toString)


  // ============================================================
  // TRY / SUCCESS / FAILURE
  // ============================================================

  val parsed =
    Try("123".toInt)

  println(parsed)


  val invalid =
    Try("abc".toInt)

  println(invalid)


  parsed match {

    case Success(value) =>
      println(s"Success: $value")

    case Failure(exception) =>
      println(s"Failure: ${exception.getMessage}")
  }


  // ============================================================
  // TRY MAP / GETOR ELSE
  // ============================================================

  val result =
    Try("123".toInt)
      .map(_ * 2)
      .getOrElse(0)

  println(result)


  // ============================================================
  // EITHER
  // ============================================================

  val success: Either[String, Int] =
    Right(100)

  val error: Either[String, Int] =
    Left("Something went wrong")

  println(success)
  println(error)


  // ============================================================
  // EITHER MAP
  // ============================================================

  println(success.map(_ * 2))


  // ============================================================
  // EITHER FOLD
  // ============================================================

  val eitherResult =
    success.fold(
      errorMessage => s"Error: $errorMessage",
      value => s"Value: $value"
    )

  println(eitherResult)


  // ============================================================
  // SEQUENCE OF OPTIONS
  // ============================================================

  val options =
    List(
      Some(1),
      Some(2),
      Some(3)
    )

  println(options.flatten)


  // ============================================================
  // SEQUENCE
  // ============================================================

  val sequence =
    List(
      Right(1),
      Right(2),
      Right(3)
    )

  println(sequence)


  // ============================================================
  // COLLECT FIRST MATCH
  // ============================================================

  val firstEven =
    List(1, 3, 5, 6, 8)
      .collectFirst {
        case x if x % 2 == 0 => x
      }

  println(firstEven)


  // ============================================================
  // COUNT
  // ============================================================

  println(
    List(1, 2, 3, 4, 5)
      .count(_ > 2)
  )


  // ============================================================
  // SIZE
  // ============================================================

  println(List(1, 2, 3).size)


  // ============================================================
  // LENGTH
  // ============================================================

  println(List(1, 2, 3).length)


  // ============================================================
  // EMPTY / NON EMPTY
  // ============================================================

  println(List.empty[Int].isEmpty)

  println(List(1).nonEmpty)


  // ============================================================
  // CONCATENATION
  // ============================================================

  val a =
    List(1, 2)

  val b =
    List(3, 4)

  println(a ++ b)

  println(a ::: b)


  // ============================================================
  // PREPEND / APPEND
  // ============================================================

  println(0 +: a)

  println(a :+ 3)


  // ============================================================
  // UPDATED
  // ============================================================

  val updateExample =
    List(10, 20, 30)

  println(
    updateExample.updated(1, 200)
  )


  // ============================================================
  // PATCH
  // ============================================================

  println(
    List(1, 2, 3, 4, 5)
      .patch(2, List(100, 200), 1)
  )


  // ============================================================
  // INIT / TAIL
  // ============================================================

  println(List(1, 2, 3, 4).init)

  println(List(1, 2, 3, 4).tail)


  // ============================================================
  // COLLECTING KEYS / VALUES FROM MAP
  // ============================================================

  scores.keys.foreach(println)

  scores.values.foreach(println)


  // ============================================================
  // MAP FILTER
  // ============================================================

  println(
    scores.filter {
      case (_, score) =>
        score >= 80
    }
  )


  // ============================================================
  // MAP MAPVALUES
  // ============================================================

  println(
    scores.view
      .mapValues(_ + 10)
      .toMap
  )


  // ============================================================
  // GROUP MAP
  // ============================================================

  val employees =
    List(
      ("Raja", "Data"),
      ("John", "AI"),
      ("Sam", "Data"),
      ("Alex", "AI")
    )

  println(
    employees.groupMap(
      _._2
    )(
      _._1
    )
  )


  // ============================================================
  // GROUP MAP REDUCE
  // ============================================================

  val sales =
    List(
      ("India", 100),
      ("USA", 200),
      ("India", 300),
      ("USA", 400)
    )

  println(
    sales.groupMapReduce(_._1)(_._2)(_ + _)
  )


  // ============================================================
  // ZIPWITH
  // ============================================================

  val x =
    List(1, 2, 3)

  val y =
    List(10, 20, 30)

  println(
    x.zip(y).map {
      case (a, b) => a + b
    }
  )


  // ============================================================
  // CORRESPONDS
  // ============================================================

  println(
    List(1, 2, 3)
      .corresponds(List(2, 4, 6))(_ * 2 == _)
  )


  // ============================================================
  // SAME ELEMENTS
  // ============================================================

  println(
    List(1, 2, 3).sameElements(
      List(1, 2, 3)
    )
  )


  // ============================================================
  // PATCH / UPDATED / TAKE / DROP
  // ============================================================

  val data =
    Vector(10, 20, 30, 40, 50)

  println(data.take(2))
  println(data.drop(2))
  println(data.slice(1, 4))
  println(data.updated(2, 999))


  // ============================================================
  // CHUNKS
  // ============================================================

  println(
    (1 to 10)
      .grouped(3)
      .toList
  )


  // ============================================================
  // SLIDING WITH STEP
  // ============================================================

  println(
    (1 to 10)
      .sliding(3, 2)
      .toList
  )


  // ============================================================
  // INDEXED SEQUENCE
  // ============================================================

  val indexed =
    List("A", "B", "C")

  indexed.zipWithIndex.foreach {
    case (value, index) =>
      println(s"index=$index value=$value")
  }


  // ============================================================
  // SORTING TUPLES
  // ============================================================

  val records =
    List(
      ("A", 30),
      ("B", 10),
      ("C", 20)
    )

  println(records.sortBy(_._2))

  println(records.sortWith(_._2 < _._2))


  // ============================================================
  // SORTING STRINGS
  // ============================================================

  val words =
    List("banana", "apple", "orange", "kiwi")

  println(words.sorted)

  println(words.sortBy(_.length))

  println(words.sortBy(_.length).reverse)


  // ============================================================
  // LONG / DOUBLE / FLOAT COLLECTIONS
  // ============================================================

  val longs =
    List(100L, 200L, 300L)

  val doubles =
    List(1.5, 2.5, 3.5)

  println(longs.sum)
  println(doubles.sum)


  // ============================================================
  // BOOLEAN COLLECTIONS
  // ============================================================

  val booleans =
    List(true, true, false)

  println(booleans.forall(identity))

  println(booleans.exists(identity))


  // ============================================================
  // RANGE OPERATIONS
  // ============================================================

  println((1 to 10).map(_ * 2))

  println((1 to 10).filter(_ % 2 == 0))

  println((1 to 10).sum)

  println((1 to 10).max)

  println((1 to 10).min)


  // ============================================================
  // ARRAY BUFFER
  // ============================================================

  val arrayBuffer =
    mutable.ArrayBuffer[Int]()

  arrayBuffer += 10
  arrayBuffer += 20
  arrayBuffer += 30

  println(arrayBuffer)

  arrayBuffer += 40

  println(arrayBuffer)

  arrayBuffer -= 20

  println(arrayBuffer)


  // ============================================================
  // LIST BUFFER
  // ============================================================

  val listBuffer =
    mutable.ListBuffer[Int]()

  listBuffer += 1
  listBuffer += 2
  listBuffer += 3

  println(listBuffer)

  listBuffer -= 2

  println(listBuffer)


  // ============================================================
  // MUTABLE ARRAY
  // ============================================================

  val mutableArray =
    mutable.ArraySeq(1, 2, 3, 4)

  println(mutableArray)


  // ============================================================
  // LAZYLIST
  // ============================================================

  // LazyList is useful for potentially infinite sequences.

  val infiniteNumbers =
    LazyList.from(1)

  println(
    infiniteNumbers
      .map(_ * 2)
      .take(5)
      .toList
  )


  // ============================================================
  // RANGE -> LAZY PROCESSING
  // ============================================================

  val lazyRange =
    (1 to 1000000)
      .view
      .map(_ * 2)
      .filter(_ % 4 == 0)

  println(lazyRange.take(5).toList)


  // ============================================================
  // PARTIAL FUNCTIONS
  // ============================================================

  val evenOnly: PartialFunction[Int, Int] = {
    case x if x % 2 == 0 =>
      x * 2
  }

  println(
    List(1, 2, 3, 4)
      .collect(evenOnly)
  )


  // ============================================================
  // FUNCTION VALUES
  // ============================================================

  val add =
    (a: Int, b: Int) => a + b

  println(add(10, 20))


  // ============================================================
  // HIGHER ORDER FUNCTION
  // ============================================================

  def calculate(
                 a: Int,
                 b: Int,
                 operation: (Int, Int) => Int
               ): Int = {

    operation(a, b)
  }

  println(calculate(10, 20, _ + _))

  println(calculate(10, 20, _ * _))


  // ============================================================
  // CURRIED FUNCTION
  // ============================================================

  def multiply(a: Int)(b: Int): Int =
    a * b

  println(multiply(10)(20))


  // ============================================================
  // PARTIALLY APPLIED FUNCTION
  // ============================================================

  def addThree(a: Int, b: Int, c: Int): Int =
    a + b + c

  val addTen =
    addThree(10, _, _)

  println(addTen(20, 30))


  // ============================================================
  // BY NAME PARAMETER
  // ============================================================

  def printTwice(value: => String): Unit = {
    println(value)
    println(value)
  }

  printTwice("Scala")


  // ============================================================
  // LAZY VAL
  // ============================================================

  lazy val expensiveCalculation = {
    println("Calculating...")
    100 * 100
  }

  println(expensiveCalculation)


  // ============================================================
  // TYPE ALIASES
  // ============================================================

  type UserId = Int

  val userId: UserId = 100

  println(userId)


  // ============================================================
  // OPTION WITH MAP / FLATMAP
  // ============================================================

  val optionalNumber =
    Some(10)

  println(optionalNumber.map(_ * 2))

  println(
    optionalNumber.flatMap(
      x => Some(x * 3)
    )
  )


  // ============================================================
  // OPTION FILTER
  // ============================================================

  println(
    Some(10)
      .filter(_ > 5)
  )

  println(
    Some(10)
      .filter(_ > 20)
  )


  // ============================================================
  // OPTION FOLD
  // ============================================================

  println(
    Some(10).fold(0)(_ + 5)
  )

  println(
    None.fold(0)(_ + 5)
  )


  // ============================================================
  // MAPVALUES / TRANSFORM
  // ============================================================

  val mapExample =
    Map(
      "A" -> 1,
      "B" -> 2
    )

  println(
    mapExample.view
      .mapValues(_ * 10)
      .toMap
  )


  // ============================================================
  // MAP FILTER KEYS
  // ============================================================

  println(
    mapExample.filter {
      case (key, _) =>
        key == "A"
    }
  )


  // ============================================================
  // MAP FILTER
  // ============================================================

  println(
    mapExample.filter {
      case (_, value) =>
        value > 1
    }
  )


  // ============================================================
  // DEFAULT MAP
  // ============================================================

  val defaultMap =
    mutable.Map[Int, Int]()
      .withDefaultValue(0)

  defaultMap(1) += 10
  defaultMap(1) += 20

  println(defaultMap(1))


  // ============================================================
  // FREQUENCY COUNTER - MUTABLE
  // ============================================================

  val frequencyMap =
    mutable.Map[Int, Int]()

  for (value <- List(1, 2, 2, 3, 3, 3)) {

    frequencyMap(value) =
      frequencyMap.getOrElse(value, 0) + 1
  }

  println(frequencyMap)


  // ============================================================
  // TWO SUM USING MAP
  // ============================================================

  val twoSumInput =
    Array(2, 7, 11, 15)

  val target =
    9

  val seen =
    mutable.Map[Int, Int]()

  for ((value, index) <- twoSumInput.zipWithIndex) {

    val complement =
      target - value

    if (seen.contains(complement)) {

      println(
        s"Two Sum: ${seen(complement)}, $index"
      )
    }

    seen(value) = index
  }


  // ============================================================
  // MAXIMUM SUM OF SUBARRAY SIZE K
  // SLIDING WINDOW
  // ============================================================

  val slidingInput =
    Array(2, 1, 5, 1, 3, 2)

  val windowSize =
    3

  var windowSum =
    slidingInput.take(windowSize).sum

  var maximumSum =
    windowSum

  for (i <- windowSize until slidingInput.length) {

    windowSum += slidingInput(i)

    windowSum -=
      slidingInput(i - windowSize)

    maximumSum =
      maximumSum max windowSum
  }

  println(
    s"Maximum window sum = $maximumSum"
  )


  // ============================================================
  // PREFIX SUM
  // ============================================================

  val prefixInput =
    Array(1, 2, 3, 4, 5)

  val prefixSum =
    prefixInput.scanLeft(0)(_ + _)

  println(prefixSum.mkString(", "))


  // ============================================================
  // SCANLEFT
  // ============================================================

  println(
    List(1, 2, 3, 4)
      .scanLeft(0)(_ + _)
  )


  // ============================================================
  // SCANRIGHT
  // ============================================================

  println(
    List(1, 2, 3, 4)
      .scanRight(0)(_ + _)
  )


  // ============================================================
  // COLLECT
  // ============================================================

  val mixed =
    List[Any](1, "Scala", 2, "Spark", 3)

  val onlyIntegers =
    mixed.collect {
      case x: Int =>
        x
    }

  println(onlyIntegers)


  // ============================================================
  // PARTIAL FUNCTION ISDEFINEDAT
  // ============================================================

  println(evenOnly.isDefinedAt(2))
  println(evenOnly.isDefinedAt(3))


  // ============================================================
  // EITHER LEFT / RIGHT
  // ============================================================

  val rightValue =
    Right(100): Either[String, Int]

  println(rightValue.isRight)
  println(rightValue.isLeft)


  // ============================================================
  // TRY RECOVER
  // ============================================================

  val recoverExample =
    Try("abc".toInt)
      .recover {
        case _: NumberFormatException =>
          0
      }

  println(recoverExample)


  // ============================================================
  // TRY RECOVERWITH
  // ============================================================

  val recoverWithExample =
    Try("abc".toInt)
      .recoverWith {
        case _: NumberFormatException =>
          Success(100)
      }

  println(recoverWithExample)


  // ============================================================
  // ASSERT
  // ============================================================

  val answer =
    2 + 2

  assert(answer == 4)


  // ============================================================
  // REQUIRE
  // ============================================================

  def divide(a: Int, b: Int): Int = {

    require(b != 0)

    a / b
  }

  println(divide(10, 2))


  // ============================================================
  // OPTION WHEN NULL MAY EXIST
  // ============================================================

  val nullableValue: String = null

  val safeValue =
    Option(nullableValue)

  println(safeValue)


  // ============================================================
  // JAVA / SCALA COLLECTION CONVERSION
  // ============================================================

  import scala.jdk.CollectionConverters._

  val javaList =
    new java.util.ArrayList[Int]()

  javaList.add(10)
  javaList.add(20)

  val scalaList =
    javaList.asScala.toList

  println(scalaList)


  // ============================================================
  // COMMON COLLECTION FUNCTION SUMMARY
  // ============================================================

  /*
   *
   * TRANSFORMATION
   *
   * map
   * flatMap
   * collect
   * flatten
   *
   *
   * FILTERING
   *
   * filter
   * filterNot
   * partition
   * takeWhile
   * dropWhile
   *
   *
   * SEARCH
   *
   * find
   * exists
   * forall
   * contains
   * indexOf
   * indexWhere
   *
   *
   * AGGREGATION
   *
   * sum
   * product
   * min
   * max
   * reduce
   * reduceLeft
   * reduceRight
   * fold
   * foldLeft
   * foldRight
   * scanLeft
   * scanRight
   * count
   *
   *
   * SORTING
   *
   * sorted
   * sortBy
   * sortWith
   * minBy
   * maxBy
   *
   *
   * COLLECTION MANIPULATION
   *
   * take
   * takeRight
   * drop
   * dropRight
   * slice
   * splitAt
   * updated
   * patch
   * reverse
   * distinct
   * ++
   * +:
   * :+
   * ::
   *
   *
   * GROUPING
   *
   * groupBy
   * groupMap
   * groupMapReduce
   * grouped
   * sliding
   *
   *
   * PAIRING
   *
   * zip
   * zipWithIndex
   * unzip
   * corresponds
   * sameElements
   *
   *
   * NESTED COLLECTIONS
   *
   * flatten
   * flatMap
   *
   *
   * STRING
   *
   * length
   * head
   * last
   * charAt
   * substring
   * contains
   * startsWith
   * endsWith
   * indexOf
   * replace
   * split
   * trim
   * toUpperCase
   * toLowerCase
   * toCharArray
   *
   *
   * MAP
   *
   * get
   * getOrElse
   * contains
   * keys
   * values
   * map
   * filter
   * filterKeys
   * updated
   *
   *
   * SET
   *
   * contains
   * +
   * -
   * union
   * intersect
   * diff
   *
   *
   * RANGE
   *
   * to
   * until
   * by
   *
   *
   * OPTION
   *
   * Some
   * None
   * map
   * flatMap
   * filter
   * fold
   * getOrElse
   * foreach
   *
   *
   * ERROR HANDLING
   *
   * Try
   * Success
   * Failure
   * recover
   * recoverWith
   * Either
   * Left
   * Right
   *
   *
   * LAZY
   *
   * Iterator
   * View
   * LazyList
   *
   *
   * DSA
   *
   * sliding
   * grouped
   * zipWithIndex
   * groupBy
   * scanLeft
   * foldLeft
   * reduce
   * sortBy
   * distinct
   * contains
   * exists
   * forall
   *
   */
}

