# ScoreMe_Assignment_sriram.vemuri
This repository has the answers to the tasks

Overview

This repository contains fixes and analysis for multiple production-level defects identified across different components of a banking system. Each task focuses on a specific category such as bug fixing, concurrency, resource management, logging, and diagnostics. All changes strictly adhere to the given constraints—ensuring minimal, targeted fixes without altering existing architecture, method signatures, or business logic.

Tasks Summary

T1: LoanAccountService – Bug Fix

Resolved critical defects in getOverdueLoans() that caused NullPointerException and incorrect handling of zero-balance accounts.
Fixed multiple null-handling issues
Corrected logic for zero outstanding balance cases
Documented all fixes using // FIX: comments

T2: ConcurrentModificationException – Analysis

Performed root cause analysis of intermittent failures under peak load without modifying code.
Explained Java’s fail-fast behavior causing the exception
Identified unsafe collection modification during iteration
Suggested minimal (1–2 line) safe fix

T3: BankStatementBatchProcessor – Concurrency Fix

Addressed inconsistent processedCount values in a multi-threaded environment.
Fixed race condition in shared counter
Ensured accurate counting across threads
Added inline explanation using // FIX: comments

T4: ReportDAO – Connection Leak Fix

Resolved connection pool exhaustion issue causing application hangs.
Fixed improper resource handling leading to connection leaks
Ensured connections are released in all execution paths
Preserved query logic and mapRow() implementation

T5: DocumentValidator – Exception Handling Improvement

Improved logging and exception handling to reduce noise and increase clarity.

Prevented log flooding from expected validation failures
Differentiated validation vs runtime exceptions
Fixed silent exception swallowing
Standardized logging using SLF4J
Annotated all fixes with // FIX: comments

Constraints Followed:-
No new classes, endpoints, or business logic introduced
No renaming of methods or restructuring of packages
No changes to method signatures unless required
All existing comments preserved
All fixes annotated using // FIX: prefix
Each task handled independently
Code kept compile-safe and minimal

Key Takeaways:-
Emphasis on precision debugging rather than refactoring
Focus on real-world production issues like concurrency, leaks, and logging noise
Strict adherence to controlled change environments common in enterprise systems
Clear inline documentation for maintainability and review
