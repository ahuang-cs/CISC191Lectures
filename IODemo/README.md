# java.io
|                | Byte Based                           |                                    | Character Based                  |                            |
|:---------------|:-------------------------------------|:-----------------------------------|:---------------------------------|:---------------------------|
|                | Input                                | Output                             | Input                            | Output                     |
| Basic          | InputStream                          | OutputStream                       | Reader, InputStreamReader        | Writer, OutputStreamWriter |
| Arrays         | ByteArrayInputStream                 | ByteArrayOutputStream              | CharArrayReader                  | CharArrayWriter            |
| Files          | FileInputStream, RandomAccessFile    | FileOutputStream, RandomAccessFile | FileReader                       | FileWriter                 |
| Pipes          | PipedInputStream                     | PipedOutputStream                  | PipedReader                      | PipedWriter                |
| Buffering      | BufferedInputStream                  | BufferedOutputStream               | BufferedReader                   | BufferedWriter             |
| Filtering      | FilterInputStream                    | FilterOutputStream                 | FilterReader                     | FilterWriter               |
| Parsing        | PushbackInputStream, StreamTokenizer |                                    | PushbackReader, LineNumberReader |                            |
| Strings        |                                      |                                    | StringReader                     | StringWriter               |
| Data           | DataInputStream                      | DataOutputStream                   |                                  |
| Formatted Data |                                      | PrintStream                        |                                  | PrintWriter                |
| Objects        | ObjectInputStream                    | ObjectOutputStream                 |                                  |                            |
| Utilities      | SequenceInputStream                  |                                    |                                  |                            |


