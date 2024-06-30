### [<<Back](../README.md) | [All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Autosys
------
# Commands
* sendevent -E START_JOB -J <job name>
* sendevent -E FORCE_STARTJOB -J <job name>
* sendevent -E KILLJOB -J <job name>
* sendevent -E DELETEJOB -J <job name>
* sendevent -E JOB_ON_HOLD -J <job name>
* sendevent -E JOB_OFF_HOLD -J <job name>
* sendevent -E JOB_ON_ICE -J <job name>
* sendevent -E JOB_OFF_ICE -J <job name>
* sendevent -E CHANGE_STATUS -s STATUS -J <job name>
* sendevent -E <any event> -C "Comment to be displayed"
* sendevent -E SET_GLOBAL -G "Global Variable = value"
* Schedule an event in the future date or time
```
sendevent -E JOB_ON_HOLD -J <job name> -T "MM/DD/YYYY HH:MM"
```
* Put job on hiold at 9 AM today
```
sendevent -F JOB_ON_HOLD -J TESTJOB -T "06/27/2024 09:00"
```
* Put job on hiold at 2 PM today
```
sendevent -F JOB_ON_HOLD -J TESTJOB -T "06/27/2024 14:00"
```
* Cancel future send event
```
sendevent -E JOB_ON_HOLD -J <job name> -U -T "MM/DD/YYYY HH:MM"
```
------
# Types of machines
* Server machine
	* Machine on which `Event Server` and `Scheduler` reside
	
* Client machine
	* Machine on which `Remote Agent` is installed. This is the machine where the job actually runs
------
# Types of jobs
* Command Jobs
	* Usually executes command scripts or run a program
	* run under user id on remote machine
	* single action performed on validated machine
	* can comprise of only one command to be executed in one job
* File Watcher Jobs
	* remote process that monitors the existence and size of file
	* if it detects file - success
	* search only for one file when job is defined
* Box Jobs
	* container of jobs contains command, file watcher and even box jobs
	* itself perform no action but it can trigger other jobs to run
------
# Job status
* Autosys keep track of current state or status of every job
* Following are different status of job
	* INACTIVE(IN)
	* ACTIVATED(AC)
	* STARTING(ST)
	* RUNNING(RU)
	* SUCCESS(SU)
	* FAILURE(FA)
	* TERMINATED(TE)
	* RESTART(RE)
	* RESOURCEWAIT(RW)
	* ON_HOLE(OH)
	* ON_ICE(OI)
------
# JIL - Job Information Language
* JIL is a language that has its own syntax to describe when, where and how job should run
* Example
```
/************** JOB1 ***********/
insert_job: JOB1
job_type: c
command: /full-path/clean.sh <dirname>
machine: machine-url
owner: any-username
start_times: 00:10
permission: wx,mx,we,me
description: "Job to clean directory <dirname>"
job_terminator: 1
alarm_if_fail: 0
```
------
# JIL Essential attributes
* insert_job(job name) - used to identify the job. Must be unique. It can be from 1 to 30 characters. 
* job_type - Specifies type of job. command (c), file watcher (f), box (b)
* owner - whose user ID the command will be run under on the client machine
	* Example: `owner: root`
* machine: Client machine on which command should run
	* Example: `machine: server1`

# JIL General attributes
* description - provides comment field, used for documentation purposes only
* max_run_alarm - Maximum runtime ca be specified for job. If maximum runtime is specified, then job should not take longer than the specified time to finish
* min_run_alarm - Minimum runtime can be specified for job. Job should not end in less than specified time
* alarm_if_fail
* std_out_file
* std_err_file
* watch_file
* watch_interval - default 60 seconds
* watch_file_min_size
* command - any single unix command, shell script, NT batch file. Ex: `commandL ls -l`
* box_name
* job_terminator
* box_terminator
* date_conditions
* start_times/start_mins
* days_of_week
* condition
* run_calendar
* exclude_calendar
* term_run_time
* n_retrys
* run_window
* job_load
* priority
------
### [<<Back](../README.md) | [All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)