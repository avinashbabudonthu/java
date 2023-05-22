## Errors
### ORA-28002: the password will expire within 7 days
* Error Details
```
28002. 00000 -  "the password will expire within %s days"
*Cause:    The password of the user's account has expired. Since the user's
           account is associated with a password profile with a limited
           password grace period and grace period is yet to elapse, the user
           will not be prompted to input a new password and ORA-28002 warning
           message will continue to be displayed upon each successful login
           to the user account, until the user changes their password.
           Once the grace period elapses, the password will expire and user
           login will start failing with ORA-28001 error, until the user
           changes their password.
*Action:   Change the password or contact the database administrator.
Vendor code 28002
```
* Solution
```
alter profile "DEFAULT" limit password_life_time unlimited; -- to set never expiring password
alter profile "DEFAULT" limit password_grace_time 14; -- to set password expiring grace period to 14 days
alter user practice identified by practice; -- even though we execute one of the above queries still we need to reset password. We can reset to same old password
alter user system identified by admin; -- even though we execute one of the above queries still we need to reset password. We can reset to same old password
```