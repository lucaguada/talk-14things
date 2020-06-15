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
* JEP 345         - More local memory!
<br>
* JEP 364/365     - ZGC for everyone
<br>
* JEP 349         - Continusly spying over the JDK
<br>
* JEP 355/368     - Put more lines on that Text
<br>
* JEP 358         - Point to that Null
<br>
* JEP 325/354/361 - Switch me on!
<br>
* JEP 305         - There's a pattern here
<br>
* JEP 359         - Guinness!
<br>
* JEP 343/311     - Six-packed
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

-> ## JEP 345 - More local memory! <-

This is tricky. Non-uniform memory access (NUMA) is a method for configuring multiprocessor cluster
in a multiprocessing system for sharing memory locally. Such method improves performance and scalability.

Proposal states G1 garbage collector performance can be improved by allowing to allocate memory with such 
method. Such kind of need is actually present in large systems.

```
+XX:+UseNUMA
```

I didn't test it, so I trust it as-is.

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

-> ## JEP 349 - Continusly spying over the JDK <-



-------------------------------------------------

-> ## JEP 355/368 - Put more lines on that Text <-

-------------------------------------------------

-> ## JEP 358 - Point to that Null <-

-------------------------------------------------

-> ## JEP 325/354/361 - Switch me on! <-

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

