package com.cs.network.protocol.games;

import org.apache.mina.core.buffer.BufferDataException;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import java.nio.charset.Charset;

/**
 * A {@link ProtocolDecoder} which decodes a String using a fixed-length length prefix.
 *
 * @author <a href="http://mina.apache.org">Apache MINA Project</a>
 */
public class PrefixedStringDecoder extends CumulativeProtocolDecoder {

    public final static int DEFAULT_PREFIX_LENGTH = 4;

    //封包大小
    public final static int DEFAULT_MAX_DATA_LENGTH = 8192;

    private final Charset charset;

    private int prefixLength = DEFAULT_PREFIX_LENGTH;

    private int maxDataLength = DEFAULT_MAX_DATA_LENGTH;

    /**
     * @param charset       the charset to use for encoding
     * @param prefixLength  the length of the prefix
     * @param maxDataLength maximum number of bytes allowed for a single String
     */
    public PrefixedStringDecoder(Charset charset, int prefixLength, int maxDataLength) {
        this.charset = charset;
        this.prefixLength = prefixLength;
        this.maxDataLength = maxDataLength;
    }

    public PrefixedStringDecoder(Charset charset, int prefixLength) {
        this(charset, prefixLength, DEFAULT_MAX_DATA_LENGTH);
    }

    public PrefixedStringDecoder(Charset charset) {
        this(charset, DEFAULT_PREFIX_LENGTH);
    }

    /**
     * Sets the number of bytes used by the length prefix
     *
     * @param prefixLength the length of the length prefix (1, 2, or 4)
     */
    public void setPrefixLength(int prefixLength) {
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
     * Sets the maximum allowed value specified as data length in the incoming data
     * <p>
     * Useful for preventing an OutOfMemory attack by the peer.
     * The decoder will throw a {@link BufferDataException} when data length
     * specified in the incoming data is greater than maxDataLength
     * The default value is {@link PrefixedStringDecoder#DEFAULT_MAX_DATA_LENGTH}.
     * </p>
     *
     * @param maxDataLength maximum allowed value specified as data length in the incoming data
     */
    public void setMaxDataLength(int maxDataLength) {
        this.maxDataLength = maxDataLength;
    }

    /**
     * Gets the maximum number of bytes allowed for a single String
     *
     * @return maximum number of bytes allowed for a single String
     */
    public int getMaxDataLength() {
        return maxDataLength;
    }

    protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
        if (in.prefixedDataAvailable(prefixLength, maxDataLength)) {
            String msg = in.getPrefixedString(prefixLength, charset.newDecoder());
            out.write(msg);
            return true;
        }

        return false;
    }
}