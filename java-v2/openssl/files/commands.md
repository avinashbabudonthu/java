### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Commands
------
# Encode
* Command
```
$ openssl base64 -in notes.txt -out encode.txt
```
* base64: means base64 encoding
* -in: Input file
* -out: Output file
------
# Decode
* Command
```
$ openssl base64 -d -in encode.txt -out decode.txt
```
* base64: means base64 encoding
* -in: Input file
* -out: Output file
------
# Encrypt and encode with base64
* Command
```
$ openssl enc -aes-256-cbc -pass pass:12345 -pbkdf2 -in notes.txt -out encrypt.txt  -base64
```
* -aes-256-cbc: Encryption algorithm
* -pass pass:12345: Passcode to use for encryption. `12345` is passcode
* * -in: Input file
* -out: Output file
* -base64: Encoding type
* -pbkdf2: Password-Based Key Derivation Function 2 (PBKDF2) is a cryptographic algorithm that makes it harder for brute-force attacks to guess account passwords
* If we do encrypt only then generated encryption is non readable. If we do encode after encryption it will generate readable letters
------
# Encrypt
* Command
```
$ openssl enc -aes-256-cbc -pass pass:12345 -pbkdf2 -in notes.txt -out encrypt2.txt
```
* -aes-256-cbc: Encryption algorithm
* -pass pass:12345: Passcode to use for encryption. `12345` is passcode
* * -in: Input file
* -out: Output file
* -base64: Encoding type
* -pbkdf2: Password-Based Key Derivation Function 2 (PBKDF2) is a cryptographic algorithm that makes it harder for brute-force attacks to guess account passwords
------
# Decrypt
* Command
```
$ openssl enc -aes-256-cbc -base64 -pass pass:12345 -d -pbkdf2 -in encrypt.txt -out decrypt.txt
```
* -aes-256-cbc: Encryption algorithm
* -pass pass:12345: Passcode to use for encryption. `12345` is passcode
* * -in: Input file
* -out: Output file
* -base64: Encoding type
* -pbkdf2: Password-Based Key Derivation Function 2 (PBKDF2) is a cryptographic algorithm that makes it harder for brute-force attacks to guess account passwords
* -d: Decryption flag
------
# Bad pass key while decrypt
* Command
```
$ openssl enc -aes-256-cbc -base64 -pass pass:12346 -d -pbkdf2 -in encrypt.txt -out decrypt.txt
```
* Output
```
bad decrypt
25988:error:06065064:digital envelope routines:EVP_DecryptFinal_ex:bad decrypt:../openssl-1.1.1g/crypto/evp/evp_enc.c:583:
```
------
# Hashing or Digest
* Command
```
$ echo -n "Password@17072024" | openssl dgst -sha256
```
* Output
```
(stdin)= 68ca2a903c64b736570b93441d664ec8896425f8f0e6bc22beb9457b0afbd142
```
* echo: To print output in console
* -n: Input text
* dgst: Digest function
* -sha256: Hash Function
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)