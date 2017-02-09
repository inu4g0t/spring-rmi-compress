package ignore;

import java.rmi.server.*;
import java.io.*;

/**
 * An RMISocketFactory which enables compressed transmission.
 * We use {@link #CompressingInputStream} and {@link #CompressingOutputStream}
 * for this.
 *
 * As we extend ignore.WrappingSocketFactory, this can be used on top of another
 * {@link RMISocketFactory}.
 */
public class CompressedRMISocketFactory
        extends WrappingSocketFactory
{

    private static final long serialVersionUID = 1;

    //------------ Constructors -----------------

    /**
     * Creates a ignore.CompressedRMISocketFactory based on a pair of
     * socket factories.
     *
     * @param cFac the base socket factory used for creating client
     *   sockets. This may be {@code null}, then we will use the
     *  {@linkplain RMISocketFactory#getDefault() default socket factory}
     *  of client system where this object is finally used for
     *   creating sockets.
     *   If not null, it should be serializable.
     * @param sFac the base socket factory used for creating server
     *   sockets. This may be {@code null}, then we will use the
     *  {@linkplain RMISocketFactory#getDefault() default RMI Socket factory}.
     *  This will not be serialized to the client.
     */
    public CompressedRMISocketFactory(RMIClientSocketFactory cFac,
                                      RMIServerSocketFactory sFac) {
        super(cFac, sFac);
    }


    /**
     * Creates a ignore.CompressedRMISocketFactory based on a socket factory.
     *
     * This constructor is equivalent to
     * {@code ignore.CompressedRMISocketFactory(fac, fac)}.
     *
     * @param fac the factory to be used as a base for both client and
     *   server socket. This should be either serializable or {@code null}
     *   (then we will use the
     * {@linkplain RMISocketFactory#getDefault() default socket factory}
     *   as a base).
     */
    public CompressedRMISocketFactory(RMISocketFactory fac) {
        super(fac);
    }

    /**
     * Creates a ignore.CompressedRMISocketFactory based on the
     * {@link RMISocketFactory#getSocketFactory global socket factory}.
     *
     * This uses the global socket factory at the time of the constructor
     * call. If this is {@code null}, we will use the
     * {@linkplain RMISocketFactory#getDefault() default socket factory}
     * instead.
     */
    public CompressedRMISocketFactory() {
        super();
    }

    //-------------- Implementation -------------

    /**
     * wraps a pair of streams into compressing/decompressing streams.
     */
    protected StreamPair wrap(InputStream in, OutputStream out,
                              boolean server)
    {
        return new StreamPair(new DecompressingInputStream(in),
                new CompressingOutputStream(out));
    }
}