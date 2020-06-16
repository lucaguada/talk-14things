%title: 14 things about new Java release
%author: Luca Guadagnini
%date: 2020-06-17

-> 14 things about new Java release <-
======================================

-> Hello by Duke! <-

---

-> ## Welcome! <-

_Introduction:_

This is an only-text/IDE talk about the new version of Java, the 14th,
     released on 17th March 2020 (by now we already got an update).

Since Java 9 the release cadence incresed from randomly years to 6 months,
      with a change for licences, support and features:

Java SE 9   *September 2017*, *modules*, *incubator*, *private on interfaces*, ...
Java SE 10  *March 2018*, *var*, ...
Java SE 11  *September 2018*, *http-client*, ...
Java SE 12  *March 2019*, *switch-exp*, ...
Java SE 13  *September 2019*, *text-block*, ... 

-------------------------------------------------

-> ## Schedule <-

* Official release notes
<br>
* JEP 362         - The SPARC is gone for Solaris
<br>
* JEP 366         - Deprecate ParallelScavenge/SerialOld GC 
<br>
* JEP 363/367     - Farewell CMS&Pack200
<br>
* JEP 345         - G1 loves NUMA
<br>
* JEP 352         - Mapped Byte Buffers don't fly anymore
<br>
* JEP 364/365     - ZGC for everyone
<br>
* JEP 370         - Give me access to that Foreign Memory
<br>
* JEP 349         - Continusly Streming Events
<br>
* JEP 355/368     - Put more lines on that Text
<br>
* JEP 358         - Point to that Null
<br>
* JEP 325/354/361 - Switch me on!
<br>
* JEP 305         - There's a match with that pattern
<br>
* JEP 359         - Rec
<br>
* JEP 343/311     - Packaging
<br>
* Demo time!
<br>
* What's next?

-------------------------------------------------

-> ## Official release notes <-

Understanding difference between:
* Java Specification Request 389, or rather, Java SE 14 release notes
* OpenJDK 14.0.0 release notes

_Java SE 14_ specifies all implemented JDK Enchament Proposals

_OpenJDK 14.0.0_ may specify some implemented JEP's if not already mentioned
  in previous releases (i.e. Text Blocks, Switch Expression, ...) and mostly
  indicate bug-fixes and removals.

-------------------------------------------------

-> ## JEP 362 - The SPARC is gone for Solaris <-

Scalable Processor Architecture was developed by Sun Microsystems and Fujitsu during 80's. And it was cool.
Sun developed Solaris - in origin SunOS - for SPARC and then x86 during 90's. And it was cool as well.

Suddendly cool things come and go, just like Sun. And Solaris is not really supported by Oracle, so...

Solaris and SPARC port is now deprecated. If we try to compile for Solaris, we get:

```
error: The Solaris and SPARC ports are deprecated and may be removed in a future release. 
Use --enable-deprecated-ports=yes to suppress this error.
```

with command `--enable-deprecated-ports=yes` instead:

```
WARNING: The Solaris and SPARC ports are deprecated and may be removed in a future release.
```

So long Solaris, maybe someone will write a book about you... never mind title already taken.

-------------------------------------------------

-> ## JEP 366 - Deprecate ParallelScavenge/SerialOld G <-

Activation of Parallel Young Generation GC (named Parallel Scavenge) and 
Serial Old GC (named... well... SerialOld)

```
-XX:+UseParallelGC -XX:-UseParallelOldGC
```

such instruction is just deprecated, but not yet removed.
Reasons: not really used anymore and sometimes risky to use it because of... OutOfMemoryError's!

-------------------------------------------------

-> ## JEP 363/367 - Farewell CMS&Pack200 <-

_Pack200_ is a JAR compression scheme introduced in Java SE 5 (good times!).
Tools and API's were deprecated in Java SE 11, they are totally removed now.

_Concurrent Mark Sweep_ garbage collector was introduced in Java SE 1.4.1 (better times!).
CMS was deprecated in Java SE 9 for accelerating other better alternatives.

We are going to miss you all! (almost)

-------------------------------------------------

-> ## JEP 345 - G1 loves NUMA <-

This is tricky. Non-uniform memory access (NUMA) is a method for configuring multiprocessor cluster
in a multiprocessing system for sharing memory locally. Such method improves performance and scalability.

Proposal states G1 garbage collector performance can be improved by allowing to allocate memory with such 
method. Such kind of need is actually present in large systems.

```
+XX:+UseNUMA
```

I didn't test it, so I trust it as-is.

-------------------------------------------------

-> ## JEP 352 - Mapped Byte Buffers don't fly anymore -

The new File API's were introduced in New Input Output package (java.nio) 
  in Java SE 1.4.0 (please don't count the years).

In order to improve the File API's performance (mostly for large file scenario),
  In Java SE 7 MappedByteBuffer was now able to map portions of files 
  in the Java Virtual Memory instead of the heap.

  FileChannel class acts like a client for such kind of buffer, and it asks for 
  a specific mode of mapping 
  (private - that is copy-on-write - readonly and read&write).

The purpose of the JEP is to allow MappedByteBuffers to load portions 
  of file on Non-Volatile Memory as well.

-------------------------------------------------

-> ## JEP 364/365 - ZGC for everyone <-

Z Garbage Collector was introduced in Java SE 11 and it's generally known as ZGC.
It's a scalable low latency garbage collector with max pause times from millisec to
sub-millisec which do not increase heap size. ZGC can handle from 8MB to 16TB heap size (oh gosh!).

If you ask what Z stands for, it was a reference to ZFS, Zettabyte FileSystem, but
no-one use it anymore.

When introduced it was just for the Linux OpenJDK releases. No MacOS and no Windows.

JEP 364 solves the problem for MacOS.
JEP 365 solves the problem for Windows 10, Windows Server 2019, version 1803 for both.

Both of them are still experimental, but pretty solid.

-------------------------------------------------

-> ## JEP 349 - Continusly streaming events <-

JRockit Flight Recorder was a tool for monitoring events built by the Java Virtual Machine.
When Oracle acquired Sun Mic. (sic) rebranded the tool as Java Flight Recorder 
  and you couldn't use it because you needed a Oracle commercial licence. 
  Then it was open-sourced for OpenJDK 11.0.0 and rebranded again in JDK Flight Recorder. 

Now since JFR is open-sourced you can freely use it to watch what actually happens on your JVM 
  during the execution of your application and with Mission Control interact with 
  shown events. 

With this JEP is now even possible to consume the JVM events with a ad-hoc provided API's. 

Just use `jdk.jfr` in your `module-info` and start to play with `jdk.jfr.consumer`.

-------------------------------------------------

-> ## JEP 355/368 - Put more lines on that Text <-

Once upon a time there was JEP 326 and it was meant to introduce Raw String Literals
  in Java SE 12. But then the proposal was withdrawn.

An example:
```
var rawStringLiteral = \`
  Call me
  Ismael
\`
```

There were a lot of discussions about it, but it was rejected in favor of Text Blocks 
  introduced in Java SE 13. Some reasons are releated to the backtick:
  * backtick is hard to spot
  * backtick can be confused with single quote \` '
  * backtick is not present in all keyboard layouts (i.e. IT, try to type it under Windows)

An example of Text Blocks: 
```
var textBlock = """
  Call me 
  Ismael
"""
```

With the last releated JEP we have a second feature preview,
  this means Text Blocks are going to be feature complete for Java SE 15.

-------------------------------------------------

-> ## JEP 358 - Help us NullPointer! <-

Someone say it's a mess, someone else it's a bless, but we all actually think
  NullPointerException is a hell of exception, the most brutal one. 

And most of all it doesn't help. Let's see an example:

>   // somewhere there's a Person object
>   var email = person.getDetails().getContactInfo().getEmail();

but then when we try:

```
$ java Things14.java 
```

```
Exception in thread "main" java.lang.NullPointerException
	at Things14.main(Things14.java:17)
```

that row 17 is our method chaining, but who actually throwed the exception?
  Who knows?

Thankfully to JEP 358 we are able to get more information from NullPointerException itself!

```
$ java -XX:+ShowCodeDetailsInExceptionMessages Things14.java
```

and we get:
```
Exception in thread "main" java.lang.NullPointerException: 
  Cannot invoke "Things14$ContactInfo.getEmail()" 
  because the return value of "Things14$Details.getContactInfo()" is null
  at Things14.main(Things14.java:17)
```

Oh gosh! I need to fix that ContactInfo then! Thanks NullPointerException!

-------------------------------------------------

-> ## JEP 325/354/361 - Switch me on! <-

Switch expression is now feature complete! Which means you don't need to
enable it by using `--enable-preview` parameter in order to use it in your
Java 14 source code!

Switch expression is an improvement to the primitive statement `switch`:

```
Day asDay(int dayOfWeek) {
  switch (dayOfWeek) {
    case 0: return Day.SUNDAY;
    case 1: return Day.MONDAY;
    case 2: return Day.TUESDAY;
    ...
    default: return null;
  }
}
```

can be now expressed as following: 

```
Day asDay(int dayOfWeek) {
  return switch (dayOfWeek) {
    case 0 -> Day.SUNDAY;
    case 1 -> Day.MONDAY;
    ... 
    default -> null;
  }
}
```

or again: 
```
Color change(Color color, ChangeType type) {
  switch (type) {
    case ChangeType.Transparent:
      var transparent = new TransparentColor(
          color.red(), 
          color.green(), 
          color.blue()
        );
  }
}
```

Why all of this? Why do we need this kind of switch? Well pattern matching.
It's terribly hard to evolve a platform used by billions of applications, 
mostly because of backward compatibility. JEP's must be discussed pretty 
well and it's not possible to put features just for the sake of some 
buzz-words or hyped languages. 

But... what Java tries to evolve here is its own programming paradigm.
Object-oriented programming is a nice thing, but in some cases Functional 
programming may help as well. 

There would be so much to discuss about Switch expression, 

-------------------------------------------------

-> ## JEP 305 - There's a pattern here <-

-------------------------------------------------

-> ## JEP 359 - Guinness! <-

-------------------------------------------------

-> ## JEP 343/311 - Six-packed <-

-------------------------------------------------

-> ## Demo time! <-

-------------------------------------------------

-> ## What's next? <-

-------------------------------------------------

