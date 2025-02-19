package com.redis.lettucemod.output;

import io.lettuce.core.codec.RedisCodec;
import io.lettuce.core.internal.LettuceStrings;
import io.lettuce.core.output.CommandOutput;

import java.nio.ByteBuffer;

import com.redis.lettucemod.timeseries.Sample;

public class SampleOutput<K, V> extends CommandOutput<K, V, Sample> {

    public SampleOutput(RedisCodec<K, V> codec) {
        super(codec, new Sample());
    }

    @Override
    public void set(ByteBuffer bytes) {
        output.setValue(LettuceStrings.toDouble(decodeAscii(bytes)));
    }

    @Override
    public void set(double number) {
        output.setValue(number);
    }

    @Override
    public void set(long integer) {
        output.setTimestamp(integer);
    }
}
