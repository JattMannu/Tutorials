touch sampleFile
attr -s  myVar1 -V ThisIsMyVar sampleFile
attr -s  myVar2 -V ThisIsMyVar sampleFile
attr -g  myVar1 sampleFile
attr -l sampleFile
getfattr -d -m - sampleFile

aws s3api put-object --bucket cag-automation-reports --key dir-1/banana --body sampleFile  --profile auto
aws s3api get-object --bucket cag-automation-reports --key dir-1/banana banana 

#file_name=banana
#getfattr -d -m - $file_name


touch file1
attr -s  upload -V ThisIsMyVar file1


