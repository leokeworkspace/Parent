package com.cs.network.protocol.games;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.ProtocolEncoder;

import java.nio.charset.Charset;

/**
 * A {@link ProtocolEncoder} which encodes a string
 * using a fixed-length length prefix.
 *
 * @author <a href="http://mina.apache.org">Apache MINA Project</a>
 */
public class PrefixedStringEncoder extends ProtocolEncoderAdapter {

    public final static int DEFAULT_PREFIX_LENGTH = 4;

    public final static int DEFAULT_MAX_DATA_LENGTH = 8192;

    private final Charset charset;

    private int prefixLength = DEFAULT_PREFIX_LENGTH;

    private int maxDataLength = DEFAULT_MAX_DATA_LENGTH;

    public PrefixedStringEncoder(Charset charset, int prefixLength, int maxDataLength) {
        this.charset = charset;
        this.prefixLength = prefixLength;
        this.maxDataLength = maxDataLength;
    }

    public PrefixedStringEncoder(Charset charset, int prefixLength) {
        this(charset, prefixLength, DEFAULT_MAX_DATA_LENGTH);
    }

    public PrefixedStringEncoder(Charset charset) {
        this(charset, DEFAULT_PREFIX_LENGTH);
    }

    public PrefixedStringEncoder() {
        this(Charset.defaultCharset());
    }

    /**
     * Sets the number of bytes used by the length prefix
     *
     * @param prefixLength the length of the length prefix (1, 2, or 4)
     */
    public void setPrefixLength(int prefixLength) {
        if (prefixLength != 1 && prefixLength != 2 && prefixLength != 4) {
            throw new IllegalArgumentException("prefixLength: " + prefixLength);
        }
        this.prefixLength = prefixLength;
    }

    /**
     * Gets the length of the length prefix (1, 2, or 4)
     *
     * @return length of the length prefix
     */
    public int getPrefixLength() {
        return prefixLength;
    }

    /**
     * Sets the maximum number of bytes allowed for encoding a single String
     * (including the prefix)
     * <p>
     * The encoder will throw a {@link IllegalArgumentException} when more bytes
     * are needed to encode a String value.
     * The default value is {@link PrefixedStringEncoder#DEFAULT_MAX_DATA_LENGTH}.
     * </p>
     *
     * @param maxDataLength maximum number of bytes allowed for encoding a single String
     */
    public void setMaxDataLength(int maxDataLength) {
        this.maxDataLength = maxDataLength;
    }

    /**
     * Gets the maximum number of bytes allowed for encoding a single String     *
     *
     * @return maximum number of bytes allowed for encoding a single String (prefix included)
     */
    public int getMaxDataLength() {
        return maxDataLength;
    }

    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
        String value = (String) message;
        IoBuffer buffer = IoBuffer.allocate(value.length()).setAutoExpand(true);
        buffer.putPrefixedString(value, prefixLength, charset.newEncoder());
        if (buffer.position() > maxDataLength) {
            throw new IllegalArgumentException("Data length: " + buffer.position());
        }
        buffer.flip();
        out.write(buffer);
    }
}
